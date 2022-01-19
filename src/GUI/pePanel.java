package GUI;

import DAOJDBC.CraudDaoImp;
import DAOJDBC.DAOJDBC;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class pePanel extends JPanel implements ActionListener {
    DAOJDBC daojdbc;
    pePanel() throws SQLException {
        daojdbc =new CraudDaoImp();
        //this.setBackground(Color.cyan);
        this.setBounds(60,90,300,300);
        this.setLayout(new BorderLayout());


        showPieChart();
    }
    public void showPieChart() throws SQLException {

        //create dataset
        DefaultPieDataset barDataset = new DefaultPieDataset( );


        String dataString[]=new String[10];
        int datanumber[]=new int[10];
        dataString= daojdbc.retrive_dataString();
        datanumber= daojdbc.retrive_dataNumber();

        DefaultPieDataset dataset = new DefaultPieDataset();

        for (int i=0;i<dataString.length;i++){
            barDataset.setValue(dataString[i],datanumber[i]);

        }

        //create chart
        JFreeChart piechart = ChartFactory.createPieChart("Voting statistique",barDataset, false,true,false);//explain

        PiePlot piePlot =(PiePlot) piechart.getPlot();

        //changing pie chart blocks colors



        piePlot.setBackgroundPaint(Color.white);

        //create chartPanel to display chart(graph)
        ChartPanel barChartPanel = new ChartPanel(piechart);
        this.removeAll();
        this.add(barChartPanel, BorderLayout.CENTER);
        this.validate();
    }



    @Override
    public void actionPerformed(ActionEvent e) {

    }
}