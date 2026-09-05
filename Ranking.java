import java.util.Arrays;

public class Ranking {

    static class Player implements Comparable<Player> {
        String name;
        int matches;
        double average;
        boolean injured;

        Player(String n, int m, double a, boolean i) {
            name = n;
            matches = m;
            average = a;
            injured = i;
        }

        static boolean isDraftable(int m) {
            return m >= 10;
        }

        static boolean isDraftable(int m, boolean injured) {
            return m >= 5 && !injured;
        }

        public int compareTo(Player p) {
            return Double.compare(p.average, average);
        }
    }

    static String draftAndRank(Player[] players) {
        Player[] d = new Player[players.length];
        int n = 0;

        for (Player p : players)
            if (Player.isDraftable(p.matches) ||
                Player.isDraftable(p.matches, p.injured))
                d[n++] = p;

        d = Arrays.copyOf(d, n);
        Arrays.sort(d);

        String s = "";
        for (int i = 0; i < n; i++)
            s += (i + 1) + ". " + d[i].name + " | ";

        return s.substring(0, s.length() - 3);
    }

    public static void main(String[] args) {
        Player[] p = {
            new Player("Virat", 15, 48, false),
            new Player("Rahul", 7, 55, false),
            new Player("Sameer", 3, 60, false),
            new Player("Dev", 12, 20, true)
        };

        System.out.println(draftAndRank(p));
    }
}