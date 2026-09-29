import java.util.*;

abstract class Room {
    protected int units;

    public Room(int units) {
        this.units = units;
    }

    abstract double calculateBill();
    abstract String getType();
}

class SingleRoom extends Room {
    public SingleRoom(int units) {
        super(units);
    }

    double calculateBill() {
        return units * 8;
    }

    String getType() {
        return "SINGLE";
    }
}

class SharedRoom extends Room {
    private int occupants;

    public SharedRoom(int units, int occupants) {
        super(units);
        this.occupants = occupants;
    }

    double calculateBill() {
        return (units * 6) / occupants;
    }

    String getType() {
        return "SHARED";
    }
}

class ACRoom extends Room {
    public ACRoom(int units) {
        super(units);
    }

    double calculateBill() {
        return units * 10 + 200;
    }

    String getType() {
        return "AC";
    }
}

public class HostelElectricity {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();

            Room room;

            if (type.equals("SHARED")) {
                int units = sc.nextInt();
                int occupants = sc.nextInt();
                room = new SharedRoom(units, occupants);
            } else {
                int units = sc.nextInt();

                if (type.equals("SINGLE")) {
                    room = new SingleRoom(units);
                } else {
                    room = new ACRoom(units);
                }
            }

            double bill = room.calculateBill();
            total += bill;

            System.out.printf("%s: %.2f%n",
                    room.getType(), bill);
        }

        System.out.printf("Total: %.2f%n", total);
    }
}