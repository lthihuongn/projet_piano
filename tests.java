import javax.sound.midi.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class tests {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new PianoFrame();
        });
    }
}

class PianoFrame extends JFrame {
    private Synthesizer synthesizer;
    private MidiChannel channel;

    public PianoFrame() {
        // Initialisation de la fenêtre
        setTitle("Simulateur de Piano");
        setSize(800, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(1, 7));

        // Initialisation du synthétiseur MIDI
        try {
            synthesizer = MidiSystem.getSynthesizer();
            synthesizer.open();
            channel = synthesizer.getChannels()[0];
        } catch (MidiUnavailableException e) {
            e.printStackTrace();
        }

        // Fréquences des touches
        int[] notes = {60, 62, 64, 65, 67, 69, 71}; // Do, Ré, Mi, Fa, Sol, La, Si (MIDI)

        // Créer les touches du piano
        String[] labels = {"Do (C)", "Ré (D)", "Mi (E)", "Fa (F)", "Sol (G)", "La (A)", "Si (B)"};
        for (int i = 0; i < notes.length; i++) {
            int note = notes[i];
            JButton button = new JButton(labels[i]);
            button.setFont(new Font("Arial", Font.BOLD, 16));
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    playNote(note);
                }
            });
            add(button);
        }

        setVisible(true);
    }

    // Méthode pour jouer une note MIDI
    private void playNote(int note) {
        if (channel != null) {
            channel.noteOn(note, 600); // Note MIDI (600 = vélocité/volume)
            try {
                Thread.sleep(300); // Durée de la note
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            channel.noteOff(note);
        }
    }

    // Fermer le synthétiseur lorsque la fenêtre est fermée
    @Override
    public void dispose() {
        super.dispose();
        if (synthesizer != null) {
            synthesizer.close();
        }
    }
}
