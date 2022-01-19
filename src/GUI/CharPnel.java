package GUI;

import DAOJDBC.CraudDaoImp;
import DAOJDBC.DAOJDBC;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class CharPnel extends JPanel implements ActionListener {
    DAOJDBC daojdbc;
    CharPnel() throws SQLException {

        daojdbc =new CraudDaoImp();
        //this.setBackground(Color.cyan);
        this.setBounds(400,90,300,300);
        this.setLayout(new BorderLayout());


        showBarChart();
    }
    public void showBarChart() throws SQLException {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        String dataString[]=new String[10];
        int datanumber[]=new int[10];
        dataString= daojdbc.retrive_dataString();
        datanumber= daojdbc.retrive_dataNumber();


        for (int i=0;i<dataString.length;i++) {
            dataset.setValue(datanumber[i], "score", dataString[i]);


        }
        JFreeChart chart = ChartFactory.createBarChart("Chart Statistique",null,null,
                dataset, PlotOrientation.VERTICAL, false,true,false);

        CategoryPlot categoryPlot = chart.getCategoryPlot();
        //categoryPlot.setRangeGridlinePaint(Color.BLUE);
        categoryPlot.setBackgroundPaint(Color.WHITE);
        BarRenderer renderer = (BarRenderer) categoryPlot.getRenderer();
        Color clr3 = new Color(0, 102, 255);
        renderer.setSeriesPaint(0, clr3);
        ChartPanel barpChartPanel = new ChartPanel(chart);
        this.removeAll();
        this.add(barpChartPanel, BorderLayout.CENTER);
        this.validate();
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
