import java.util.Arrays;

public class Score {
    static void applyMultipliers(double[] scores, int c, int v) {
        scores[c] *= 2;
        scores[v] *= 1.5;
    }

    public static void main(String[] args) {
        double[] scores = {40, 55, 30, 62};

        applyMultipliers(scores, 1, 3);

        System.out.println(Arrays.toString(scores));
    }
}