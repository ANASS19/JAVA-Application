package GUI;

import DAOJDBC.*;
import SingleConnection.Connect;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class AjouteCondidat extends JPanel implements ActionListener {
    JButton Ajoute;
    JTextField nompartiefield;
    JTextField numpartiefield;
    JTextField faullname;
    JTextField cin;
    JLabel label;

    JLabel nome_partielabel;
    JLabel num_partielabel;
    JLabel fullnameelabel;
    JLabel cinelabel;
    CraudDaoImp craudDaoImp;

    public AjouteCondidat() {
        craudDaoImp=new CraudDaoImp();
        this.setBackground(new Color(51, 204, 255));
        this.setBounds(200, 0, 800, 800);

        Ajoute =new JButton("Ajoute");
        Ajoute.setFocusable(false);

        nompartiefield =new JTextField();
        numpartiefield =new JTextField();
        faullname =new JTextField();
        cin =new JTextField();

        label =new JLabel("Ajoute condidat");
        label.setFont( new Font("Comic Sans",Font.BOLD,25));
        label.setBounds(340,100,300,100);

        nome_partielabel =new JLabel("nom de partie:");
        nome_partielabel.setFont( new Font("Comic Sans",Font.BOLD,15));
        nome_partielabel.setBounds(150,170,300,100);

        num_partielabel =new JLabel("numer de partie:");
        num_partielabel.setFont( new Font("Comic Sans",Font.BOLD,15));
        num_partielabel.setBounds(150,230,300,100);

        fullnameelabel =new JLabel("fullname:");
        fullnameelabel.setFont( new Font("Comic Sans",Font.BOLD,15));
        fullnameelabel.setBounds(150,300,300,100);

        cinelabel =new JLabel("CIN");
        cinelabel.setFont( new Font("Comic Sans",Font.BOLD,15));
        cinelabel.setBounds(150,360,300,100);

        nompartiefield.setBounds(300,200,300,50);
        numpartiefield.setBounds(300,260,300,50);
        faullname.setBounds(300,320,300,50);
        cin.setBounds(300,380,300,50);

        Ajoute.setBounds(350,450,150,50);
        Ajoute.addActionListener(this);




        this.add(num_partielabel);
        this.add(nome_partielabel);
        this.add(fullnameelabel);
        this.add(cinelabel);
        this.add(Ajoute);


        this.add(label);
        this.add(nompartiefield);
        this.add(numpartiefield);
        this.add(faullname);
        this.add(cin);

        this.setLayout(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==Ajoute){
            String nompartiefieldstring=nompartiefield.getText();
            int numpartiefieldstring=  Integer.parseInt(numpartiefield.getText());
            String faullnamestring=faullname.getText();
            String cinstring=cin.getText();
            craudDaoImp.ajouteCondidat(nompartiefieldstring,numpartiefieldstring, faullnamestring, cinstring);
            JOptionPane.showMessageDialog(null,"condidat ajjouton succes");

        }
    }
}
