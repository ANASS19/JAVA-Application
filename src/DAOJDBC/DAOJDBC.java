package DAOJDBC;

import java.sql.SQLException;

public interface DAOJDBC {
    public void voteCondidat(String name,String usernamev );
    //public void Adminlogin(String username,String password,String usertype);
    //public void voteurlogin(String username,String password,String usertype);
    public boolean checkusername(String username) throws SQLException;

    public int insertVoteur(String fullname, String username, String email, String CIN, String password,  String user_type) throws SQLException;
    public boolean checisvote(String username)throws SQLException;

    public String[][] retrive_data() throws SQLException;

    public int[]retrive_dataNumber() throws SQLException;
    public String[] retrive_dataString() throws SQLException;

    public void ajouteCondidat(String nompartiefieldstring,int numpartiefieldstring,String faullnamestring,String cinstring);
    public void deletCondidat(String condidatodelet);

}
