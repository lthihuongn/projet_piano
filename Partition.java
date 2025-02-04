import java.util.ArrayList;
import java.util.List;

public class Partition {
    private List<Note> notes;

    public Partition() {
        this.notes = new ArrayList<>();
    }

    public void ajouterNote(Note note) {
        notes.add(note);
    }

    public void afficher() {
        for (Note note : notes) {
            System.out.println(note);
        }
    }
}