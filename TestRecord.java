import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.util.ArrayList;
import java.util.List;


    public class TestRecord {
        public static void main(String[] args) {
            Record record = new Record("melodie_test.txt");

            // Vérification si le fichier existe déjà
            record.checkError();

            // Ajout de notes avec différents instruments
            record.addNote("Piano", new Note("Do", 0.5));
            record.addNote("Violon", new Note("Ré", 0.75));
            record.addNote("Xylophone", new Note("Mi", 1.0));
            record.addNote("Orgue", new Note("Fa", 1.25));

            // Sauvegarde de la mélodie
            record.close();

            System.out.println("Test d'enregistrement terminé !");
        }
    }





class Record {
    private String fileName;
    private List<String> playedNotes;

    public Record(String fileName) {
        this.fileName = fileName;
        this.playedNotes = new ArrayList<>();
        checkError();
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void addNote(String instrument, Note note) {
        String noteRecord = "Instrument: " + instrument + ", Note: " + note.toString();
        playedNotes.add(noteRecord);
    }

    public void close() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (String record : playedNotes) {
                writer.write(record);
                writer.newLine();
            }
            System.out.println("Enregistrement sauvegardé dans " + fileName);
        } catch (IOException e) {
            System.err.println("Erreur lors de l'enregistrement : " + e.getMessage());
        }
    }

    public void checkError() {
        File file = new File(fileName);
        if (file.exists()) {
            System.out.println("Warning! Un fichier avec ce nom existe déjà : " + fileName);
        }


    }
}
