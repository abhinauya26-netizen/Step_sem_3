import java.util.*;

abstract class Transport {
    protected double distance;

    public Transport(double distance) {
        this.distance = distance;
    }

    abstract double calculateFare();
    abstract String getType();
}

class Bus extends Transport {
    public Bus(double distance) {
        super(distance);
    }

    double calculateFare() {
        return Math.min(10, 2 + (0.10 * distance));
    }

    String getType() {
        return "BUS";
    }
}

class Train extends Transport {
    public Train(double distance) {
        super(distance);
    }

    double calculateFare() {
        return 3 + (0.15 * distance);
    }

    String getType() {
        return "TRAIN";
    }
}

class Metro extends Transport {
    private double peakHourFactor;

    public Metro(double distance, double peakHourFactor) {
        super(distance);
        this.peakHourFactor = peakHourFactor;
    }

    double calculateFare() {
        return (1.50 + (0.20 * distance)) * peakHourFactor;
    }

    String getType() {
        return "METRO";
    }
}

public class TransportFare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double distance = sc.nextDouble();

            Transport transport;

            if (type.equals("BUS")) {
                transport = new Bus(distance);
            } else if (type.equals("TRAIN")) {
                transport = new Train(distance);
            } else {
                double factor = sc.nextDouble();
                transport = new Metro(distance, factor);
            }

            double fare = transport.calculateFare();
            total += fare;

            System.out.printf("%s: %.2f%n", transport.getType(), fare);
        }

        System.out.printf("Total: %.2f%n", total);
    }
}