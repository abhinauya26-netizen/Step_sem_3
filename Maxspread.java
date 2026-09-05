public class Maxspread {
    static String findMinMaxSpread(int[] a) {
        int min = a[0], max = a[0];

        for (int x : a) {
            if (x < min) min = x;
            if (x > max) max = x;
        }

        return "Min: " + min +
               " | Max: " + max +
               " | Spread: " + (max - min);
    }

    public static void main(String[] args) {
        int[] a = {45, 82, 79, 90, 33, 90, 61};

        System.out.println(findMinMaxSpread(a));
    }
}