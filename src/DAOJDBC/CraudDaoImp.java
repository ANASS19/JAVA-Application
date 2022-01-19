package DAOJDBC;

import Acteurs.Voteur;
import SingleConnection.Connect;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CraudDaoImp implements DAOJDBC{

    Connection connection;
    @Override
    public void voteCondidat(String name,String usernamev ) {
        try {

            Connection connection= Connect.getCon();
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery("select score  from condidats where nom_partie= '"+name+"'");
            if (resultSet.next()) {
                System.out.println("TEST" + resultSet.getInt("score"));
                int res=resultSet.getInt("score");
                System.out.println("name: ="+res);
                res=res+1;
                int votees=statement.executeUpdate("update condidats set score= "+res+" where nom_partie='"+name+"'");
                int disable=statement.executeUpdate("update client_voteur set vote_check= 1 where username='"+usernamev+"'");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public boolean checkusername(String username) throws SQLException {
        Connection connection= Connect.getCon();
        Statement statement=connection.createStatement();
        boolean userna_existe=false;
        ResultSet resultSet=statement.executeQuery("select * from client_voteur where username='"+username+"'");
        if (resultSet.next()){
            userna_existe=true;
            JOptionPane.showMessageDialog(null,"This username is already taken chose another one",
                    "Username Failes",2);
        }
        return  userna_existe;
    }

    @Override
    public int insertVoteur(String fullname, String username, String email, String CIN, String password,  String user_type) throws SQLException {
        Voteur voteur=new Voteur(fullname, username, email, CIN, password , user_type);
        Connection connection= Connect.getCon();
        Statement statement=connection.createStatement();
        int resultSet=statement.executeUpdate("insert into client_voteur values ('"+voteur.getVoter_id()+"','"+fullname+"','"+username+"','"+email+"','"+CIN+"','"+password +"','"+voteur.getVote_check()+"','"+user_type+"')");
        return  resultSet;
    }

    @Override
    public boolean checisvote(String username) throws SQLException {
        Connection connection= Connect.getCon();
        Statement statement=connection.createStatement();
        boolean userna_existe=false;
        ResultSet resultSett=statement.executeQuery("select vote_check from client_voteur where username='"+username+"'");
        if (resultSett.next()){
            System.out.println("debug"+resultSett.getString("vote_check"));
            if (Integer.parseInt(resultSett.getString("vote_check"))>0){
                userna_existe=true;
                JOptionPane.showMessageDialog(null,"you are deja vote",
                        "Username Failes",2);}

        }
        return  userna_existe;

    }

    @Override
    public String[][] retrive_data() throws SQLException {
        Connection connection= Connect.getCon();
        Statement statement=connection.createStatement();
        ResultSet resultSet=statement.executeQuery("select * from condidats ");

        int row = 0;
        String data[][]=new String[20][20];
        while (resultSet.next()){

            data[row][0] = resultSet.getString("nom_partie");
            data[row][1] = resultSet.getString("num_partie");
            data[row][2] = resultSet.getString("fullnamee");
            data[row][3] = resultSet.getString("CIN");
            data[row][4] = resultSet.getString("score");

            row++;
        }
        return  data;
    }

    @Override
    public int[] retrive_dataNumber() throws SQLException {

        Connection connection= Connect.getCon();
        Statement statement=connection.createStatement();
        ResultSet count=statement.executeQuery("select count(*) from CONDIDATS");
        int n=0;
        while (count.next()){
            n=count.getInt("count(*)");
        }
        System.out.println(n);
        int datanumber[]=new int[n];
        ResultSet resultSet=statement.executeQuery("select score from condidats ");

        int i=0;
        while (resultSet.next()){
            datanumber[i]=resultSet.getInt("score");
            i+=1;
        }
        return datanumber;
    }

    @Override
    public String[] retrive_dataString() throws SQLException {
        Connection connection= Connect.getCon();
        Statement statement=connection.createStatement();
        ResultSet count=statement.executeQuery("select count(*) from CONDIDATS");
        int n=0;
        while (count.next()){
            n=count.getInt("count(*)");
        }
        System.out.println(n);
        String dataString[]=new String[n];
        ResultSet resultSet=statement.executeQuery("select nom_partie from condidats ");
        int i=0;
        while (resultSet.next()){
            dataString[i]=resultSet.getString("nom_partie");
            i+=1;
        }
        return dataString;

    }

    @Override
    public void ajouteCondidat(String nompartiefield,int numpartiefield,String faullname,String cin) {
        Connection connection= Connect.getCon();
        Statement statement= null;
        try {
            statement = connection.createStatement();
            int resultSet=statement.executeUpdate("insert into condidats values ('"+nompartiefield+"','"+numpartiefield+"','"+numpartiefield+"','"+numpartiefield+"',0)");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void deletCondidat(String condidatodelet) {
        Connection connection= Connect.getCon();
        Statement statement= null;
        try {
            statement = connection.createStatement();
            int resultSet=statement.executeUpdate("delete from condidats where fullnamee ='"+condidatodelet+"'");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


}
