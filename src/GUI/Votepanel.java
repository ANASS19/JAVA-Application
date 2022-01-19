package GUI;

import DAOJDBC.*;
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
public class Votepanel extends JPanel {
    ArrayList<String> listcondidate;
    DAOJDBC daojdbc;
    public Votepanel(ArrayList<String> listcondidate,String usernamev){
        daojdbc =new CraudDaoImp();
        this.setBackground(new Color(51, 204, 255));
        this.setBounds(200,0,800,800);
        JPanel votelistpanel =new JPanel();
        votelistpanel.setBounds(10,90,765,500);
        ButtonGroup group=new ButtonGroup();
        String test="anass";
        for (String name:listcondidate){
            JRadioButton radioButton=new JRadioButton(name);
            radioButton.addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    if(e.getSource()==radioButton) {
                        String name=radioButton.getText();
                        System.out.println(radioButton.getText());
                        daojdbc.voteCondidat(name,usernamev);
                    }
                }
            });
            group.add(radioButton);
            votelistpanel.add(radioButton);
        }
        votelistpanel.setLayout(new FlowLayout(FlowLayout.CENTER,50,50));
        this.add(votelistpanel);
        this.setLayout(null);
    }

}
