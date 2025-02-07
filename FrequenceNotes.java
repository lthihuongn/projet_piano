import java.util.HashMap;
import java.util.Map;

public class FrequenceNotes {
    private static final Map<String, Integer> notesMIDI = new HashMap<>();

    static {
        // Liste des notes
        String[] notes = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};

        // Génération des notes de C0 à B8 avec MIDI correct
        for (int octave = 0; octave <= 8; octave++) {
            for (int i = 0; i < notes.length; i++) {
                int midiValue = (octave * 12) + i + 12; // Décalage de 12 car MIDI commence à C0=12
                String noteName = notes[i] + octave;
                notesMIDI.put(noteName, midiValue);
            }
        }
    }

    // Fonction pour récupérer la valeur MIDI d'une note
    public static int getMidi(String note) {
        return notesMIDI.getOrDefault(note.toUpperCase(), -1);
    }
}
