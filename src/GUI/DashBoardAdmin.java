package GUI;

import SingleConnection.Connect;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DashBoardAdmin extends JFrame implements ActionListener {
    JPanel headpanel;
    JPanel leftpanel;
    JButton Homebutton;
    JButton ajotecondidat;
    JButton deletcondidat;

    JLabel userlabel;
    JLabel namedashboardlabel;
    JTabbedPane tabdedpanel;
    Home Home;
    AjouteCondidat ajouteCondidat;
    DeleteCondidat deleteCondidat;
    String username;
    ArrayList<String> listcondidate;
    public DashBoardAdmin(String username) throws SQLException {


        ImageIcon image=new ImageIcon("ans.jpg");
        headpanel =new JPanel();

        Home =new Home(  listcondidate);
        ajouteCondidat =new AjouteCondidat();
        deleteCondidat =new DeleteCondidat();
        leftpanel=new JPanel();
        tabdedpanel =new JTabbedPane();

        Homebutton =new JButton("Home");
        ajotecondidat =new JButton("AddCondidat");
        deletcondidat =new JButton("DeleteCondidat");



        userlabel = new JLabel();
        userlabel.setText(username);
        namedashboardlabel =new JLabel();
        namedashboardlabel.setText("Dashboard");
        Homebutton.setFocusable(false);
        Homebutton.addActionListener(this);

        ajotecondidat.setFocusable(false);
        ajotecondidat.addActionListener(this);

        deletcondidat.setFocusable(false);
        deletcondidat.addActionListener(this);

        tabdedpanel.setBounds(198,0,800,800);
        Homebutton.setFont( new Font("Comic Sans",Font.BOLD,15));
        Homebutton.setForeground(Color.cyan);
        Homebutton.setBackground(Color.LIGHT_GRAY);
        Homebutton.setBounds(50,200,120,50);

        ajotecondidat.setFont( new Font("Comic Sans",Font.BOLD,13));
        ajotecondidat.setForeground(Color.cyan);
        ajotecondidat.setBackground(Color.LIGHT_GRAY);
        ajotecondidat.setBounds(50,280,120,50);


        deletcondidat.setFont( new Font("Comic Sans",Font.BOLD,13));
        deletcondidat.setForeground(Color.cyan);
        deletcondidat.setBackground(Color.LIGHT_GRAY);
        deletcondidat.setBounds(50,360,120,50);



        headpanel.setBounds(0,0,1000,100);
        headpanel.setBackground(Color.LIGHT_GRAY);
        leftpanel.setBounds(0,0,200,800);
        leftpanel.setBackground(new Color(0, 102, 255));
        userlabel.setBounds(50,5,150,80);
        namedashboardlabel.setBounds(420,5,300,80);
        userlabel.setFont( new Font("Comic Sans",Font.BOLD,25));
        namedashboardlabel.setFont( new Font("Comic Sans",Font.BOLD,25));

        leftpanel.add(Homebutton);
        leftpanel.add(ajotecondidat);
        leftpanel.add(deletcondidat);

        headpanel.add(userlabel);
        headpanel.add(namedashboardlabel);
        headpanel.setLayout(null);
        leftpanel.setLayout(null);
        tabdedpanel.add("Home",Home);
        tabdedpanel.add("Home",ajouteCondidat);
        tabdedpanel.add("Home",deleteCondidat);

        this.setTitle("Application de vote electronique");

        this.add(headpanel);
        this.add(leftpanel);
        this.add(tabdedpanel);
        this.setSize(1000,800);
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.setIconImage(image.getImage());
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==Homebutton){
            System.out.println("5adam");
            tabdedpanel.setSelectedIndex(0);
            Homebutton.setBackground(Color.yellow);
            ajotecondidat.setBackground(Color.LIGHT_GRAY);
            deletcondidat.setBackground(Color.LIGHT_GRAY);
        }
       if (e.getSource()==ajotecondidat){
            tabdedpanel.setSelectedIndex(1);
            System.out.println("5adam");
             ajotecondidat.setBackground(Color.yellow);
            Homebutton.setBackground(Color.LIGHT_GRAY);
            deletcondidat.setBackground(Color.LIGHT_GRAY);
            System.out.println("chatbutton");

        }
        if (e.getSource()==deletcondidat){
            tabdedpanel.setSelectedIndex(2);
            System.out.println("5adam");
            deletcondidat.setBackground(Color.yellow);
            Homebutton.setBackground(Color.LIGHT_GRAY);
            ajotecondidat.setBackground(Color.LIGHT_GRAY);
            System.out.println("chatbutton");

        }

    }
}
