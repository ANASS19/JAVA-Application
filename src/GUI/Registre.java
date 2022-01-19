package GUI;
import Acteurs.Voteur;
import SingleConnection.Connect;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import DAOJDBC.*;
public class Registre extends JFrame implements ActionListener {
    JButton registerbutton;
    JButton coonectebutton;
    JButton resetbutton;
    JLabel fullnamelabel;
    JLabel usernameLabel;
    JLabel emailLabel;
    JLabel CINlabel;
    JLabel passwordlabel;
    JPanel headpannel;
    JPanel loginpanel;
    JLabel titlelabel;
    JTextField fullnamefield;
    JTextField usernamefield;
    JTextField emailfield;
    JTextField CINfield;
    JLabel SelectUserlabel;
    JComboBox comboBox;
    JPasswordField passwordfield;
    DAOJDBC daojdbc;
    public Registre(){
        daojdbc =new CraudDaoImp();
        ImageIcon image=new ImageIcon("ans.jpg");
        headpannel=new JPanel();
        loginpanel=new JPanel();
        registerbutton =new JButton("register ");
        coonectebutton=new JButton("login");
        resetbutton =new JButton("reset");
        registerbutton.setFocusable(false);
        coonectebutton.setFocusable(false);
        resetbutton.setFocusable(false);
        fullnamelabel = new JLabel("fullname:");
        usernameLabel = new JLabel("username:");
        emailLabel = new JLabel("Email:");
        CINlabel = new JLabel("CIN:");
        passwordlabel = new JLabel("password:");
        fullnamefield = new JTextField();
        usernamefield =new JTextField();
        emailfield = new JTextField();
        CINfield =new JTextField();
        passwordfield = new JPasswordField();
        String [] listusers={"voteur","Admin"};
        comboBox=new JComboBox(listusers);
        comboBox.setBounds(175,280,200,25);
        SelectUserlabel = new JLabel("Select User:");
        SelectUserlabel.setBounds(100,280,200,25);
        titlelabel =new JLabel("Register");
        titlelabel.setFont( new Font("Comic Sans",Font.BOLD,25));
        titlelabel.setBounds(200,50,300,30);
        coonectebutton.setBounds(275,320,100,25);
        registerbutton.setBounds(175,320,100,25);
        resetbutton.setBounds(220,380,100,25);
        fullnamelabel.setBounds(100,30,75,25);
        usernameLabel.setBounds(100,80,75,25);
        emailLabel.setBounds(100,130,75,25);
        CINlabel.setBounds(100,180,75,25);
        passwordlabel.setBounds(100,230,75,25);
        fullnamefield.setBounds(175,30,200,25);
        usernamefield.setBounds(175,80,200,25);
        emailfield.setBounds(175,130,200,25);
        CINfield.setBounds(175,180,200,25);
        passwordfield.setBounds(175,230,200,25);
        registerbutton.addActionListener(this);
        coonectebutton.addActionListener(this);
        resetbutton.addActionListener(this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,600);
        headpannel.setLayout(null);
        loginpanel.setLayout(null);
        headpannel.setBackground(Color.lightGray);
        headpannel.setBounds(0,0,500,150);
        loginpanel.setBackground(new Color(0, 102, 255));
        loginpanel.setBounds(0,150,500,450);
        loginpanel.add(coonectebutton);
        loginpanel.add(registerbutton);
        loginpanel.add(resetbutton);
        loginpanel.add(fullnamelabel);
        loginpanel.add(usernameLabel);
        loginpanel.add(emailLabel);
        loginpanel.add(CINlabel);
        loginpanel.add(passwordlabel);
        loginpanel.add(fullnamefield);
        loginpanel.add(usernamefield);
        loginpanel.add(emailfield);
        loginpanel.add(CINfield);
        loginpanel.add(passwordfield);
        loginpanel.add(SelectUserlabel);
        loginpanel.add(comboBox);
        headpannel.add(titlelabel);
        this.setTitle("Application de vote electronique");
        this.setResizable(false);
        this.add(headpannel);
        this.add(loginpanel);
        this.setLayout(null);
        this.setVisible(true);
        this.setIconImage(image.getImage());
    }
    public boolean verifyFields(){
        String fullname=fullnamefield.getText();
        String username =usernamefield.getText();
        String email=emailfield.getText();
        String CIN=CINfield.getText();
        String password=passwordfield.getText();
        if (fullname.trim().equals("") || username.trim().equals("") ||
                email.trim().equals("") || CIN.trim().equals("") ||
                password.trim().equals("")  ){
            JOptionPane.showMessageDialog(null,"one or more fields are empty");
            return  false;
        }
        else {
            return  true;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==registerbutton) {
            String fullname=fullnamefield.getText();
            String username =usernamefield.getText();
            String email=emailfield.getText();
            String CIN=CINfield.getText();
            String password=passwordfield.getText();
            String user_type=comboBox.getSelectedItem().toString();
            System.out.println("usertype: "+user_type);
            if (verifyFields()){
                try {
                    if (!daojdbc.checkusername(username)){
                        int r=daojdbc.insertVoteur( fullname,  username,  email,  CIN,  password,   user_type);
                        if (r>0){
                            JOptionPane.showMessageDialog(null,"register suses");
                            new Login();
                        }
                        else {
                            JOptionPane.showMessageDialog(null,"register failed");
                        }
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }

        }
        if(e.getSource()==resetbutton) {
            fullnamefield.setText("");
            usernamefield.setText("");
            emailfield.setText("");
            CINfield.setText("");
            passwordfield.setText("");

        }
        if(e.getSource()==coonectebutton) {
            System.out.println("this registre button");
            this.dispose();
            new Login();
        }
    }
}
/*System.out.println("faulname: "+fullname);
            System.out.println("username: "+username);
            System.out.println("email: "+email);
            System.out.println("CIN: "+CIN);
            System.out.println("password: "+password);*/