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
public class Login extends JFrame implements ActionListener {
    JButton coonectebutton;
    JButton registerbutton;
    JButton resetbutton;
    JComboBox comboBox;
    JTextField username;
    JPasswordField password;
    JPanel headpannel;
    JPanel loginpanel;
    JLabel usernamelabel;
    JLabel SelectUserlabel;
    JLabel passwordLabel;
    JTextField usernamefield;
    JPasswordField passwordField;
    JLabel titlelabel;
    DAOJDBC daojdbc;
    public Login(){
        daojdbc =new CraudDaoImp();
        ImageIcon image=new ImageIcon("ans.jpg");
        headpannel=new JPanel();
        loginpanel=new JPanel();
        coonectebutton =new JButton("coonecte");
        registerbutton=new JButton("register");
        resetbutton =new JButton("reset");
        String [] listusers={"voteur","Admin"};
        comboBox=new JComboBox(listusers);
        coonectebutton.setFocusable(false);
        registerbutton.setFocusable(false);
        resetbutton.setFocusable(false);
        usernamelabel = new JLabel("username:");
        passwordLabel = new JLabel("password:");
        SelectUserlabel = new JLabel("Select User:");
        usernamefield = new JTextField();
        passwordField =new JPasswordField();
        titlelabel =new JLabel("login");
        titlelabel.setFont( new Font("Comic Sans",Font.BOLD,25));
        titlelabel.setBounds(200,50,300,30);
        coonectebutton.setBounds(175,240,100,25);
        resetbutton.setBounds(275,240,100,25);
        registerbutton.setBounds(220,300,100,25);
        comboBox.setBounds(175,200,200,25);
        usernamelabel.setBounds(100,100,75,25);
        passwordLabel.setBounds(100,150,75,25);
        SelectUserlabel.setBounds(100,200,200,25);
        usernamefield.setBounds(175,100,200,25);
        passwordField.setBounds(175,150,200,25);
        coonectebutton.addActionListener(this);
        registerbutton.addActionListener(this);
        resetbutton.addActionListener(this);
        password = new JPasswordField();
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
        loginpanel.add(usernamelabel);
        loginpanel.add(passwordLabel);
        loginpanel.add(usernamefield);
        loginpanel.add(passwordField);
        loginpanel.add(comboBox);
        loginpanel.add(SelectUserlabel);
        headpannel.add(titlelabel);
        this.setTitle("Application de vote electronique");
        this.setResizable(false);
        this.add(headpannel);
        this.add(loginpanel);
        this.setLayout(null);
        this.setVisible(true);
        this.setIconImage(image.getImage());
    }
    public void Adminlogin(String username,String password,String usertype){
        if (username.equals("")|| password.equals("")|| usertype.equals("")){
            JOptionPane.showMessageDialog(rootPane,"soome fields are empty","error",1);
        }
        else{
            try {
                Connection connection= Connect.getCon();
                Statement statement=connection.createStatement();
                ResultSet resultSet=statement.executeQuery("select * from ADMINISTRATEUR where username='"+username+
                        "' and password = '"+password+"' and user_type ='"+usertype+"'");

                if (resultSet.next()){
                    JOptionPane.showMessageDialog(null,"login suses");
                    ResultSet listcondidat=statement.executeQuery("select nom_partie  from condidats");
                    ArrayList <String> listcondidate =new ArrayList<>();
                    while (listcondidat.next()){
                        listcondidate.add(listcondidat.getString("nom_partie"));
                    }
                    new DashBoardAdmin(username);
                    this.dispose();

                }
                else{
                    JOptionPane.showMessageDialog(null,"login failed");

                }
            }
            catch (Exception ex){
                System.out.println(""+ex);
            }
        }
    }
    public void voteurlogin(String username,String password,String usertype){
        if (username.equals("")|| password.equals("")|| usertype.equals("")){
            JOptionPane.showMessageDialog(rootPane,"soome fields are empty","error",1);
        }
        else{
            try {
                if (!daojdbc.checisvote(username)){


                    Connection connection= Connect.getCon();
                    Statement statement=connection.createStatement();
                    ResultSet resultSet=statement.executeQuery("select * from client_voteur where username='"
                            +username+"' and password = '"+password+"' and user_type ='"+usertype+"'");

                    if (resultSet.next()){
                        JOptionPane.showMessageDialog(null,"login suses");
                        ResultSet listcondidat=statement.executeQuery("select nom_partie  from condidats");
                        ArrayList <String> listcondidate =new ArrayList<>();
                        while (listcondidat.next()){
                            listcondidate.add(listcondidat.getString("nom_partie"));
                        }
                        new DashBoardVoteurs(username,listcondidate);
                        this.dispose();
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"login failed");

                    }
                }
                else {
                    JOptionPane.showMessageDialog(null,"you deja vote");

                }
            }
            catch (Exception ex){
                System.out.println(""+ex);
            }
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==coonectebutton) {
            System.out.println("this connection button");
            String username=usernamefield.getText();
            String password=passwordField.getText();
            String usertype=comboBox.getSelectedItem().toString();
            System.out.println("usertype: "+usertype);
            if (usertype =="voteur"){
                voteurlogin(username,password,usertype);
            }
            else {
                Adminlogin(username,password,usertype);
            }
        }
        if(e.getSource()==resetbutton) {
            usernamefield.setText("");
            passwordField.setText("");
        }
        if(e.getSource()==registerbutton) {
            System.out.println("this registre button");
            this.dispose();
            new Registre();
        }

    }
}

/*
System.out.println("username: "+username);
            System.out.println("password: "+password);
            System.out.println("usertype: "+usertype);*/