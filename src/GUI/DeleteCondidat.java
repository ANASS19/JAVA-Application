package GUI;

import DAOJDBC.CraudDaoImp;
import SingleConnection.Connect;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteCondidat extends JPanel implements ActionListener {

    JButton Delete;
    JTextField textFieldtodelet;
    JLabel label;
    CraudDaoImp craudDaoImp;


    public DeleteCondidat(){
        craudDaoImp=new CraudDaoImp();
        this.setBackground(new Color(51, 204, 255));
        this.setBounds(200,0,800,800);

        Delete =new JButton("Delet");
        Delete.setFocusable(false);
        textFieldtodelet =new JTextField();
        label =new JLabel("suprime condidat");
        label.setFont( new Font("Comic Sans",Font.BOLD,25));

        label.setBounds(300,250,300,100);
        textFieldtodelet.setBounds(300,350,200,50);
        Delete.setBounds(350,450,100,50);
        Delete.addActionListener(this);


        this.add(label);
        this.add(textFieldtodelet);
        this.add(Delete);
        this.setLayout(null);


    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==Delete){
            String condidatodelet=textFieldtodelet.getText();
            craudDaoImp.deletCondidat(condidatodelet);
            JOptionPane.showMessageDialog(null,"Selete condidat  succes");

        }
    }
}
