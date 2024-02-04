public class Main {
    private final String[] name = { "Dr. Smith", "Dr. Johnson", "Dr. Williams", "Dr. Jones", "Dr. Brown", "Dr. Davis", "Dr. Miller", "Dr. Wilson", "Dr. Moore", "Dr. Taylor", "Dr. Anderson", "Dr. Thomas", "Dr. Jackson", "Dr. White", "Dr. Harris", "Dr. Martin", "Dr. Thompson", "Dr. Garcia", "Dr. Martinez", "Dr. Robinson", "Dr. Clark", "Dr. Rodriguez", "Dr. Lewis", "Dr. Lee", "Dr. Walker", "Dr. Hall", "Dr. Allen", "Dr. Young", "Dr. Hernandez", "Dr. King", "Dr. Wright", "Dr. Lopez", "Dr. Hill", "Dr. Scott", "Dr. Green", "Dr. Adams", "Dr. Baker", "Dr. Gonzalez", "Dr. Nelson", "Dr. Carter", "Dr. Mitchell", "Dr. Perez", "Dr. Roberts", "Dr. Turner", "Dr. Phillips", "Dr. Campbell", "Dr. Parker", "Dr. Evans", "Dr. Edwards", "Dr. Collins", "Dr. Stewart", "Dr. Sanchez", "Dr. Morris", "Dr. Rogers", "Dr. Reed", "Dr. Cook", "Dr. Morgan", "Dr. Bell", "Dr. Murphy", "Dr. Bailey", "Dr. Rivera", "Dr. Cooper", "Dr. Cox", "Dr. Howard", "Dr. Ward", "Dr. Torres", "Dr. Peterson", "Dr. Gray", "Dr. Ramirez", "Dr. James", "Dr. Watson", "Dr. Brooks", "Dr. Kelly", "Dr. Sanders", "Dr. Price", "Dr. Bennett", "Dr. Wood", "Dr. Barnes", "Dr. Ross", "Dr. Henderson", "Dr. Coleman", "Dr. Jenkins", "Dr. Perry", "Dr. Powell", "Dr. Long", "Dr. Patterson", "Dr. Hughes", "Dr. Flores", "Dr. Washington", "Dr. Butler", "Dr. Simmons", "Dr. Foster", "Dr. Gonzales", "Dr. Bryant", "Dr. Alexander", "Dr. Russell", "Dr. Griffin", "Dr. Diaz", "Dr. Hayes", "Dr. Myers", "Dr. Ford", "Dr. Hamilton", "Dr. Graham", "Dr. Sullivan", "Dr. Wallace", "Dr. Woods", "Dr. Cole", "Dr. West", "Dr. Jordan", "Dr. Owens" };

    public static void main(String[] args) {
        // Creates varies patients with varing illness/injury (Most illness/injury are not noted in doctors' treatable)
        MinorCare p1 = new MinorCare("Brian", "Acute Myocardial Infarction", 17, false, "low");
        NormalCare p2 = new NormalCare("Link", "Influenza", 13, false, "high");
        MajorCare p3 = new MajorCare("James", "Myocardial Infarction", 41, false, "mid");
        // List created to track all patients
        pplList list = new pplList();
        docList dList = new docList();
        // A doctor is made
        ES d1 = new ES("Andy", 3);
        GP d2 = new GP("Thomas", 1);
        MS d3 = new MS("Triston", 10);
        SS d4 = new SS("Shaun", 2);
        // Patient added to the doctor's queue
        d1.addPatient(p1);
        // Patients comes into the hospital and is tracked
        list.addPerson(p1);
        list.addPerson(p2);
        list.addPerson(p3);
        dList.addDoc(d1);
        dList.addDoc(d2);
        dList.addDoc(d3);
        dList.addDoc(d4);
        System.out.print(list);
        // Successfully sorts the list
        list.sort();
        System.out.print(list);
        // Removing a patient
        list.removePerson(p1);
        // Another patient added to doctor
        d1.addPatient(p2);
        System.out.println(d1);
        // Successfully treated a patient
        System.out.println(d1.treat(p1));
        System.out.println(d1);
        // Manually removed a patient without treating
        d1.removePatient(p2);
        System.out.println(d1);
        d1.addPatient(p3);
        System.out.println(d1);
        // Treating a patient that the current doctor can't fix (Doesn't treat)
        System.out.println(d1.treat(p3));
        // Duplicate patients can't happen
        d1.addPatient(p3);
        list.addPerson(p1);
        list.addPerson(p2);
        list.addPerson(p3);
        list.sort();
        dList.pplToDoc(list);
        System.out.println(d1);
        System.out.println(dList);
    }
}