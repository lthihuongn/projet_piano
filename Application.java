public class Application {
    private MusicPlayer player;
    private String instrumentActuel;

    public Application() {
        player = new MusicPlayer();
        instrumentActuel = "Piano"; // Instrument par défaut
    }

    public void choisirInstrument(String instrument) {
        instrumentActuel = instrument;
        player.changerInstrument(instrument);
    }

    public void jouerNote(String note) {
        int midi = FrequenceNotes.getMidi(note);
        if (midi > 0) {
            player.jouerNote(midi, 500); // Durée par défaut : 500ms
        }
    }

    public void fermer() {
        player.fermer();
    }
}