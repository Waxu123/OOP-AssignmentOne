import java.util.ArrayList;

// "Part1:基类HealthProfessional";
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
    // "Part5:appointmentList存放Appointment";
    static ArrayList<Appointment> appointmentList = new ArrayList<>();

    // "运行主函数main";
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

        // "Part5:添加2个GeneralPractitioner 2个Gastroenterology的预约到appointmentList";
        System.out.println("第五部分");
        createAppointment("John Doe", "1234567890", "10:00", General1);
        createAppointment("Jane Smith", "0987654321", "11:00", General2);
        createAppointment("Mark Brown", "1122334455", "14:30", Gastroenterology1);
        createAppointment("Mark", "1234999999", "14:30", Gastroenterology2);

        // "Part5:输出已预约的列表";
        printExistingAppointments();
        // "Part5:取消预约";
        cancelBooking("1234567890");
        // "Part5:取消后更新的预约列表";
        printExistingAppointments();
        // "Part5:取消不存在的";
        cancelBooking("1212121212");
    }

    // "Part5:创建预约createAppointment";
    public static void createAppointment(String name, String phone, String time, HealthProfessional doctor) {
        // "生成appointment";
        Appointment appointment = new Appointment(name, phone, time, doctor);
        // "添加到appointmentList";
        appointmentList.add(appointment);
        // "添加成功";
        System.out.println("create appointment success!");
    }

    // "Part5:输出已预约列表printExistingAppointments";
    public static void printExistingAppointments() {
        // "判断预约列表是否为空";
        if (appointmentList.isEmpty()) {
            System.out.println("please add appointment");
            return;
        }

        // "不是空的就打印预约列表appointmentList";
        for (int i = 0; i < appointmentList.size(); i++) {
            appointmentList.get(i).printDetails();
            System.out.println("------------------------------");
        }
    }

    // "Part5:取消预约cancelBooking";
    public static void cancelBooking(String phone) {
        int index = -1;
        for (int i = 0; i < appointmentList.size(); i++) {
            // "在预约列表里找是否有该手机号的预约equals比较phone是否相等;"
            if (appointmentList.get(i).phone.equals(phone)) {
                // "找出对应的位置index";
                index = i;
                break;
            }
        }
        // "index如果大于-1找到就remove";
        if (index > -1) {
            appointmentList.remove(index);
            System.out.println("cancel: " + phone);
        } else {
            System.out.println("error:" + phone);
        }
    }
}
