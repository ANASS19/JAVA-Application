package GUI;

import DAOJDBC.*;
import SingleConnection.Connect;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Home extends JPanel implements ActionListener {
    pePanel pePanele;
    CharPnel charPnel;
    JTable table;
    JScrollPane sp;
    JLabel titlelabel;
    DAOJDBC daojdbc;

    ArrayList<String> listcondidate =new ArrayList<>();
    Home(ArrayList<String> listcondidate) throws SQLException {
        daojdbc =new CraudDaoImp();
        pePanele =new pePanel();
        charPnel =new CharPnel();
        titlelabel =new JLabel("Affiche de condidat");
        titlelabel.setFont( new Font("Comic Sans",Font.BOLD,15));
        titlelabel.setBounds(300,360,300,100);


        String[][] data=daojdbc.retrive_data();

        String column[]={"nomd","num ","fullnamee","CIN","score"};

        DefaultTableModel defaultTableModel =new DefaultTableModel(data,column);

        table =new JTable(defaultTableModel);

        table.setBounds(100,420,500,300);
        table.setBackground(Color.lightGray);
        JScrollPane sp = new JScrollPane(table);
        //sp.setLayout(null);

        this.add(sp);
        this.add(table);
        //this.setLayout(new BorderLayout());

        this.add(titlelabel);
        this.add(pePanele);
        this.add(charPnel);
        this.setBounds(200,0,800,800);
        this.setLayout(null);
        this.setBackground(new Color(51, 204, 255));



    }
    /*
);
                fullnamee.add(resultSet.getString("fullnamee"));
                score.add(resultSet.getString("CIN"));
                score.add(resultSet.getString("score"));


*/
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
