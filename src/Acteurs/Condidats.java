package Acteurs;

public class Condidats {
    private String nom_partie;
    private int num_partie;
    private String fullnamee;
    private String CIN;
    private int score;

    public Condidats(String nom_partie, int num_partie, String fullnamee, String CIN, int score) {
        this.nom_partie = nom_partie;
        this.num_partie = num_partie;
        this.fullnamee = fullnamee;
        this.CIN = CIN;
        this.score = score;
    }

    public String getNom_partie() {
        return nom_partie;
    }

    public void setNom_partie(String nom_partie) {
        this.nom_partie = nom_partie;
    }

    public int getNum_partie() {
        return num_partie;
    }

    public void setNum_partie(int num_partie) {
        this.num_partie = num_partie;
    }

    public String getFullnamee() {
        return fullnamee;
    }

    public void setFullnamee(String fullnamee) {
        this.fullnamee = fullnamee;
    }

    public String getCIN() {
        return CIN;
    }

    public void setCIN(String CIN) {
        this.CIN = CIN;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Condidats{" +
                "nom_partie='" + nom_partie + '\'' +
                ", num_partie=" + num_partie +
                ", fullnamee='" + fullnamee + '\'' +
                ", CIN='" + CIN + '\'' +
                ", score=" + score +
                '}';
    }
}
