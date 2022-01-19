package Acteurs;

public class ADMINISTRATEUR {
    private int voter_id;
    private String fullname;
    private String username;
    private String email;
    private String CIN;
    private String password;
    private int vote_check;

    public ADMINISTRATEUR( String fullname, String username, String email, String CIN, String password, int vote_check) {

        this.fullname = fullname;
        this.username = username;
        this.email = email;
        this.CIN = CIN;
        this.password = password;
        this.vote_check = vote_check;
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

    @Override
    public String toString() {
        return "ADMINISTRATEUR{" +
                "voter_id=" + voter_id +
                ", fullname='" + fullname + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", CIN='" + CIN + '\'' +
                ", password='" + password + '\'' +
                ", vote_check=" + vote_check +
                '}';
    }
}
