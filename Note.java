public class Note {
    private String nom;
    private int frequence;
    private double duree;

    public Note(String nom, double duree) {
        this.nom = nom;
        this.frequence = FrequenceNotes.getFrequence(nom);
        this.duree = duree;
    }

    public String getNom() {
        return nom;
    }

    public int getFrequence() {
        return frequence;
    }

    public double getDuree() {
        return duree;
    }

    @Override
    public String toString() {
        return nom + " (" + frequence + " Hz) - " + duree + "s";
    }
}