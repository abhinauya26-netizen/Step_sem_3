public class Match {

    static double rowAverage(int[] row) {
        int sum = 0;
        for (int x : row)
            sum += x;
        return (double) sum / row.length;
    }

    static String classifyMatches(int[][] a, int t) {
        String s = "";

        for (int i = 0; i < a.length; i++) {
            s += "Match " + i + ": " +
                 (rowAverage(a[i]) >= t ? "Power Surge" : "Normal");

            if (i < a.length - 1)
                s += " | ";
        }
        return s;
    }

    public static void main(String[] args) {
        int[][] a = {{4,6,8}, {10,12,14}, {2,3,1}};

        System.out.println(classifyMatches(a, 8));
    }
}