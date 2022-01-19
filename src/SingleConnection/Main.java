package SingleConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        try {
            System.out.println("debut");
            Connection connection=Connect.getCon();
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery("select * from condidats");
            String [][] arr=new String[20][20];

            ArrayList<String> nom_partie = new ArrayList<String>();
            ArrayList<String> num_partie = new ArrayList<String>();
            ArrayList<String> fullnamee = new ArrayList<String>();
            ArrayList<String> CIN = new ArrayList<String>();
            ArrayList<String> score = new ArrayList<String>();
            Object[][] data = new Object[5][5];
            int row = 0;
            while (resultSet.next()) {
                for (int i = 0; i < 5; i++) {
                    data[row][i] = resultSet.getObject(i+1);
                }
                row++;
            }
            //System.out.println(data.);

        }
        catch (SQLException e){
            System.out.println("Problem au niveau de base ou acces au donnes");
        }

    }


}
/*
System.out.print("nom de parti = "+resultSet.getString("nom_partie")+"    ");
                System.out.print("numero de partie = "+resultSet.getString("num_partie")+"    ");
                System.out.print("full name = "+resultSet.getString("fullnamee")+"     ");
                System.out.print("cin = "+resultSet.getString("CIN")+"    ");
                System.out.println("score = "+resultSet.getString("score")+"    ");

                nom_partie.add(resultSet.getString("nom_partie"));
                num_partie.add(resultSet.getString("num_partie"));
                fullnamee.add(resultSet.getString("fullnamee"));
                score.add(resultSet.getString("CIN"));
                score.add(resultSet.getString("score"));
                */