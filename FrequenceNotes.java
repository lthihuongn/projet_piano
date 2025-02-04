import java.util.HashMap;
import java.util.Map;

public class FrequenceNotes {
    private static final Map<String, Integer> notesFrequences = new HashMap<>();

    static {
        notesFrequences.put("A#1", 58);
        notesFrequences.put("C2", 65);
        notesFrequences.put("F2", 87);
        notesFrequences.put("A#2", 117);
        notesFrequences.put("A2", 110);
        notesFrequences.put("G2", 98);
        notesFrequences.put("F1", 44);
        notesFrequences.put("C1", 33);
        // Ajoutez ici toutes les notes nécessaires...
    }

    public static int getFrequence(String note) {
        return notesFrequences.getOrDefault(note, 0);
    }
}