package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
public class DashBoardVoteurs extends JFrame implements ActionListener {
    JPanel headpanel;
    JPanel leftpanel;
    Votepanel votepanel;
    Chatpanel chatpanel;
    JTabbedPane tabdedpanel;
    JButton votebutton;
    JButton chatbutton;
    JLabel userlabel;
    String username;
    ArrayList<String> listcondidate =new ArrayList<>();
//chatpanel =new Chatpanel();
    public DashBoardVoteurs(String username,ArrayList<String> listcondidate) throws IOException {
        ImageIcon image=new ImageIcon("ans.jpg");
        headpanel =new JPanel();
        leftpanel=new JPanel();
        tabdedpanel =new JTabbedPane();
        votepanel=new Votepanel(listcondidate,username);
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String datetimesend = myDateObj.format(myFormatObj);

        Socket socket =new Socket("localhost",1234);
        chatpanel =new Chatpanel(socket,username,datetimesend);
        chatpanel.listenForMessage();
        votebutton =new JButton("Vote");
        chatbutton =new JButton("Chat");
        userlabel = new JLabel();
        userlabel.setText(username);
        votebutton.setFocusable(false);
        chatbutton.setFocusable(false);
        votebutton.setFont( new Font("Comic Sans",Font.BOLD,15));
        votebutton.setForeground(Color.cyan);
        votebutton.setBackground(Color.LIGHT_GRAY);
        votebutton.addActionListener(this);
        chatbutton.addActionListener(this);
        chatbutton.setFont( new Font("Comic Sans",Font.BOLD,15));
        chatbutton.setForeground(Color.cyan);
        chatbutton.setBackground(Color.LIGHT_GRAY);
        tabdedpanel.setBackground(Color.cyan);
        headpanel.setBounds(0,0,1000,100);
        //(0,0,800,700)
        tabdedpanel.setBounds(198,0,800,800);
        headpanel.setBackground(Color.LIGHT_GRAY);
        leftpanel.setBounds(0,0,200,800);
        leftpanel.setBackground(new Color(0, 102, 255));
        votebutton.setBounds(50,200,120,50);
        chatbutton.setBounds(50,260,120,50);
        userlabel.setBounds(50,5,150,80);
        userlabel.setFont( new Font("Comic Sans",Font.BOLD,25));
        leftpanel.add(votebutton);
        leftpanel.add(chatbutton);
        headpanel.add(userlabel);
        headpanel.setLayout(null);
        leftpanel.setLayout(null);
        tabdedpanel.add("resultapanel",votepanel);
        tabdedpanel.add("chatpanel",chatpanel);
        //tabdedpanel.setLayout(null);
        this.setResizable(false);
        this.setTitle("Application de vote electronique");
        this.add(headpanel);
        this.add(leftpanel);
        this.add(tabdedpanel);
        this.setSize(1000,800);

        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.setIconImage(image.getImage());
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==votebutton){
            System.out.println("vote");
            tabdedpanel.setSelectedIndex(0);
            votebutton.setBackground(Color.yellow);
            chatbutton.setBackground(Color.LIGHT_GRAY);
        }
        if (e.getSource()==chatbutton){
            tabdedpanel.setSelectedIndex(1);
            chatbutton.setBackground(Color.yellow);
            votebutton.setBackground(Color.LIGHT_GRAY);
            System.out.println("chatbutton");
        }
    }
}
