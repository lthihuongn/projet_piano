


import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.util.ArrayList;
import java.util.List;



    public class TestRecord {
        public static void main(String[] args) {
            Record record = new Record("melodie2.txt");
            record.checkError();

            // Ajout de notes à l'enregistrement
            record.addNote("Piano", new Note("Do", 0.5));
            record.addNote("Piano", new Note("Ré", 0.5));
            record.addNote("Piano", new Note("Mi", 0.5));
            record.addNote("Piano", new Note("Fa", 0.5));

            // Sauvegarde de la mélodie
            record.close();
        }
    }





class Record {
    private String fileName;
    private List<String> playedNotes;
    private Partition partition;

    public Record(String fileName) {
        this.fileName = fileName;
        this.playedNotes = new ArrayList<>();
        this.partition = new Partition();
    }

    public void addNote(String instrument, Note note) {
        String noteRecord = "Instrument: " + instrument + ", Note: " + note.toString();
        playedNotes.add(noteRecord);
        partition.ajouterNote(note);
    }

    public void emptyingRecord() {
        playedNotes.clear();
        partition = new Partition();
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

    public Partition getPartition() {
        return partition;
    }

    public void checkError() {

        File file = new File(fileName);
        if (file.exists()) {
            System.out.println("Warning! Un fichier avec ce nom existe déjà : " + fileName);
        }
    }
}
