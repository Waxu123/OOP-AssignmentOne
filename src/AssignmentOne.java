
// "Part1:HealthProfessional";
class HealthProfessional {
    int id;
    String name;
    String description;

    public HealthProfessional() {
    }

    public HealthProfessional(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    // "printDetails";
    public void printDetails() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Description: " + description);
    }
}

// "Part2:创建子类GeneralPractitioner";
class GeneralPractitioner extends HealthProfessional {

    public GeneralPractitioner() {
    }

    public GeneralPractitioner(int id, String name, String description) {
        super(id, name, description);
    }

    // "打印详情printDetails";
    public void printDetails() {
        super.printDetails();
        System.out.println("Specialty: HealthProfessional");
    }
}

// "Part2:自定义Gastroenterology";
class Gastroenterology extends HealthProfessional {
    // "专业specialty";
    String specialty = "Gastroenterology";

    public Gastroenterology() {

    }

    public Gastroenterology(int id, String name, String description) {
        super(id, name, description);
    }

    // "打印函数printDetails";
    public void printDetails() {
        super.printDetails();
        System.out.println("Specialty: " + this.specialty);
    }
}

// "Part4:预约类Appointment";
class Appointment {

    String name;
    String phone;
    String time;
    HealthProfessional doctor;

    public Appointment() {

    }

    public Appointment(String name, String phone, String time, HealthProfessional doctor) {
        this.name = name;
        this.phone = phone;
        this.time = time;
        this.doctor = doctor;
    }

    // "打印预约详情printDetails";
    public void printDetails() {
        System.out.println("Name: " + name);
        System.out.println("Phone: " + phone);
        System.out.println("Time: " + time);
        doctor.printDetails();
    }
}

// "AssignmentOne";
public class AssignmentOne {
 

    // "main";
    public static void main(String[] args) {
        // "Part3:创建三名GeneralPractitioner和两名Gastroenterology";
        GeneralPractitioner General1 = new GeneralPractitioner(1, "Taylor", "Pediatric care");
        GeneralPractitioner General2 = new GeneralPractitioner(2, "Emily White", "Mental health");
        GeneralPractitioner General3 = new GeneralPractitioner(3, "John Smith", "Geriatric care");
        Gastroenterology Gastroenterology1 = new Gastroenterology(1, "Alice Johnson", "Specialist in liver diseases");
        Gastroenterology Gastroenterology2 = new Gastroenterology(2, "Bob Lee", "Expert in colonoscopy procedures");

        // "Part3:输出全部医疗专业人员的信息用printDetails";
        General1.printDetails();
        System.out.println("------------------------------");
        General2.printDetails();
        System.out.println("------------------------------");
        General3.printDetails();
        System.out.println("------------------------------");
        Gastroenterology1.printDetails();
        System.out.println("------------------------------");
        Gastroenterology2.printDetails();
        System.out.println("------------------------------");


    }

    }
