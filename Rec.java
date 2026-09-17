class Re {
    String studentName;
    String company;
    double packageLpa;

    Re(String studentName, String company, double packageLpa) {
        this.studentName = studentName;
        this.company = company;
        this.packageLpa = packageLpa;
    }

    void printRecord() {
        System.out.println(studentName + " -> " + company + " @ " + packageLpa + " LPA");
    }
}

public class Rec {
    public static void main(String[] args) {

        Re[] records = {
            new Re("Ravi", "TCS", 4.5),
            new Re("Anitha", "Zoho", 6.2),
            new Re("Karthik", "Infosys", 4.0)
        };

        for (Re record : records) {
            record.printRecord();
        }
    }
}