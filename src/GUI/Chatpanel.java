package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Chatpanel extends JPanel  implements ActionListener {
    private Socket socket;
    private BufferedReader bufferedReader;
    public BufferedWriter bufferedWriter;
    private String username;
    private String datetimesend;
    ////////////////////////////////////////
    private JButton sendbutton;
    private JTextField messagefield;
    private JTextArea chatarea;

    Chatpanel(Socket socket, String username , String datetimesend){

        sendbutton=new JButton("send");
        messagefield=new JTextField();
        chatarea=new JTextArea();

        JScrollPane jScrollPane=new JScrollPane(chatarea);


        this.setBackground(new Color(51, 204, 255));
        this.setBounds(200,0,800,800);//panel green
        chatarea.setBounds(10,90,765,500);
        messagefield.setBounds(10,600,765,50);
        sendbutton.setBounds(300,660,150,50);

        jScrollPane.setBounds(10,90,765,500);

        validate();

        //this.add(chatarea);
        this.add(sendbutton);
        this.add(messagefield);
        this.setLayout(null);
        //this.add(chatarea);
        this.add(sendbutton);
        this.add(messagefield);
        sendbutton.addActionListener(this);
        this.add(jScrollPane);
        this.setLayout(null);
        this.setVisible(true);
        try {
            this.socket=socket;
            this.bufferedWriter=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.username=username;
            this.datetimesend=datetimesend;

        }
        catch (IOException e){
            closeEverything(socket,bufferedReader,bufferedWriter);
        }

    }

    public void  sendMessage(String mesg){
        try {
            bufferedWriter.write(username);
            bufferedWriter.newLine();
            bufferedWriter.flush();
            bufferedWriter.write(username + ": "+mesg);
            bufferedWriter.newLine();
            bufferedWriter.write("time: "+datetimesend);
            bufferedWriter.newLine();
            bufferedWriter.flush();

        }
        catch (IOException e){
            closeEverything(socket,bufferedReader,bufferedWriter);
        }

    }

    public  void listenForMessage(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                String msgFromGroupChat;

                while (socket.isConnected()){
                    try {
                        msgFromGroupChat=bufferedReader.readLine();
                        setAreaMessage(msgFromGroupChat);
                        System.out.println(msgFromGroupChat);
                    }
                    catch (IOException e){
                        closeEverything(socket,bufferedReader,bufferedWriter);
                    }

                }
            }
        }).start();
    }
    public void closeEverything(Socket socket ,BufferedReader bufferedReader,BufferedWriter bufferedWriter){
        try {
            if (bufferedReader != null){
                bufferedReader.close();
            }
            if (bufferedWriter != null){
                bufferedWriter.close();
            }
            if (socket != null){
                socket.close();
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
    public String getAreaMessage(){
        String text=this.chatarea.getText().trim() + "\n";
        return text;
    };
    public void setAreaMessage(String message){
        message+="\n";
        this.chatarea.setText(getAreaMessage()+"\n"+message);

    };

    public String getFieldMessage(){
        String text=this.messagefield.getText().trim() + "\n";
        return text;
    };



    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sendbutton) {
            //setAreaMessage(getFieldMessage());
            this.sendMessage(getFieldMessage());
            messagefield.setText("");
        }
    }
}
