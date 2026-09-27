import java.util.Arrays;

class Playlist {
    private String[] songs;
    private int songCount;

    public Playlist(int maxSize) {
        songs = new String[maxSize];
        songCount = 0;
    }

    public void addSong(String song) {
        if (songCount < songs.length) {
            songs[songCount] = song;
            songCount++;
        }
    }

    public String[] getSongs() {
        return Arrays.copyOf(songs, songCount);
    }

    public int getSongCount() {
        return songCount;
    }
    public static void main(String[] args) {
    Playlist p = new Playlist(10);

    p.addSong("Song A");
    p.addSong("Song B");

    String[] copy = p.getSongs();

    System.out.println(copy[0]);
    System.out.println(copy[1]);
    System.out.println(p.getSongCount());

    copy[0] = "Hacked";

    System.out.println(p.getSongs()[0]);
}
}
