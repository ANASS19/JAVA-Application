package Acteurs;

public class Voteur {
    private static int voter_id=1;
    private String fullname;
    private String username;
    private String email;
    private String CIN;
    private String password;
    private int vote_check;
    private String user_type;

    public Voteur(String fullname, String username, String email, String CIN, String password,  String user_type) {
        this.fullname = fullname;
        this.username = username;
        this.email = email;
        this.CIN = CIN;
        this.password = password;
        this.vote_check = 0;
        this.user_type = user_type;
        voter_id++;
    }



    public int getVoter_id() {
        return voter_id;
    }

    public void setVoter_id(int voter_id) {
        this.voter_id = voter_id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCIN() {
        return CIN;
    }

    public void setCIN(String CIN) {
        this.CIN = CIN;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getVote_check() {
        return vote_check;
    }

    public void setVote_check(int vote_check) {
        this.vote_check = vote_check;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }
    @Override
    public String toString() {
        return "Voteur{" +
                ", fullname='" + fullname + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", CIN='" + CIN + '\'' +
                ", password='" + password + '\'' +
                ", vote_check=" + vote_check +
                ", user_type='" + user_type + '\'' +
                '}';
    }
}
