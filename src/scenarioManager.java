import javax.print.Doc;
import java.util.*;

public class scenarioManager {

    private static final String[] docNames = { "Dr. Smith", "Dr. Johnson", "Dr. Williams", "Dr. Jones", "Dr. Brown", "Dr. Davis", "Dr. Miller", "Dr. Wilson", "Dr. Moore", "Dr. Taylor", "Dr. Anderson", "Dr. Thomas", "Dr. Jackson", "Dr. White", "Dr. Harris", "Dr. Martin", "Dr. Thompson", "Dr. Garcia", "Dr. Martinez", "Dr. Robinson", "Dr. Clark", "Dr. Rodriguez", "Dr. Lewis", "Dr. Lee", "Dr. Walker", "Dr. Hall", "Dr. Allen", "Dr. Young", "Dr. Hernandez", "Dr. King", "Dr. Wright", "Dr. Lopez", "Dr. Hill", "Dr. Scott", "Dr. Green", "Dr. Adams", "Dr. Baker", "Dr. Gonzalez", "Dr. Nelson", "Dr. Carter", "Dr. Mitchell", "Dr. Perez", "Dr. Roberts", "Dr. Turner", "Dr. Phillips", "Dr. Campbell", "Dr. Parker", "Dr. Evans", "Dr. Edwards", "Dr. Collins", "Dr. Stewart", "Dr. Sanchez", "Dr. Morris", "Dr. Rogers", "Dr. Reed", "Dr. Cook", "Dr. Morgan", "Dr. Bell", "Dr. Murphy", "Dr. Bailey", "Dr. Rivera", "Dr. Cooper", "Dr. Cox", "Dr. Howard", "Dr. Ward", "Dr. Torres", "Dr. Peterson", "Dr. Gray", "Dr. Ramirez", "Dr. James", "Dr. Watson", "Dr. Brooks", "Dr. Kelly", "Dr. Sanders", "Dr. Price", "Dr. Bennett", "Dr. Wood", "Dr. Barnes", "Dr. Ross", "Dr. Henderson", "Dr. Coleman", "Dr. Jenkins", "Dr. Perry", "Dr. Powell", "Dr. Long", "Dr. Patterson", "Dr. Hughes", "Dr. Flores", "Dr. Washington", "Dr. Butler", "Dr. Simmons", "Dr. Foster", "Dr. Gonzales", "Dr. Bryant", "Dr. Alexander", "Dr. Russell", "Dr. Griffin", "Dr. Diaz", "Dr. Hayes", "Dr. Myers", "Dr. Ford", "Dr. Hamilton", "Dr. Graham", "Dr. Sullivan", "Dr. Wallace", "Dr. Woods", "Dr. Cole", "Dr. West", "Dr. Jordan", "Dr. Owens" };
    private static final String[] patientNames = {"James", "Mark", "Robert", "Michael", "Chris", "Jay", "Nancy", "Lisa", "Ashley", "Mina", "Sarah", "Jessica", "Linda", "Elisha", "Mimi", "Richard"};
    private static final String[] possibleInjury = {"Cholecystitis", "Inguinal Hernia", "Appendicitis", "Coronary Artery Bypass Grafting", "Lung Cancer Resection", "Meningioma", "Lumbar Disc Herniation", "Osteoarthritis of the Knee", "Hip Fractures", "Skin Cancer Removal", "Cleft Lip and Palate Repair", "Influenza", "Type 2 Diabetes Mellitus", "Hypertension", "Asthma", "Otitis Media", "Obesity", "Anxiety Disorders", "Depression", "Hyperlipidemia", "Allergic Rhinitis", "Acute Myocardial Infarction", "Acute Respiratory Distress Syndrome", "Traumatic Brain Injury", "Sepsis", "Polytrauma", "Myocardial Infarction", "Congestive Heart Failure", "Type 1 Diabetes Mellitus", "Graves' Disease", "Crohn's Disease", "Hepatitis C", "Breast Cancer", "Non-Hodgkin Lymphoma", "Rheumatoid Arthritis", "Systemic Lupus Erythematosus"};
    public static void getDoctors(docList doctors, String template){
        for (int i = 0; i < doctors.returnDoctors().size(); i++){
            doctors.removeDoc(doctors.getDoc(i));
        }

        // four different doctor cases
        if (template.equals("Set 1")) {
            doctors.addDoc(new ES("Doctor Sid", 5));
            doctors.addDoc(new ES("Doctor Andy", 3));
            doctors.addDoc(new GP("Doctor Thomas", 12));
            doctors.addDoc(new MS("Doctor Triston", 6));
            doctors.addDoc(new MS("Doctor Akshay", 4));
            doctors.addDoc(new SS("Doctor Nabiha", 2));
        } else if (template.equals("Set 2")) {
            doctors.addDoc(new ES(docNames[(int) (Math.random() * docNames.length)], (int) (Math.random() * 10)));
            doctors.addDoc(new GP(docNames[(int) (Math.random() * docNames.length)], (int) (Math.random() * 10)));
            doctors.addDoc(new GP(docNames[(int) (Math.random() * docNames.length)], (int) (Math.random() * 10)));
            doctors.addDoc(new MS(docNames[(int) (Math.random() * docNames.length)], (int) (Math.random() * 10)));
            doctors.addDoc(new SS(docNames[(int) (Math.random() * docNames.length)], (int) (Math.random() * 10)));
            doctors.addDoc(new SS(docNames[(int) (Math.random() * docNames.length)], (int) (Math.random() * 10)));
        } else if (template.equals("Set 3")) {
            doctors.addDoc(new ES(docNames[(int) (Math.random() * docNames.length)], (int) (Math.random() * 10)));
            doctors.addDoc(new GP(docNames[(int) (Math.random() * docNames.length)], (int) (Math.random() * 10)));
            doctors.addDoc(new MS(docNames[(int) (Math.random() * docNames.length)], (int) (Math.random() * 10)));
            doctors.addDoc(new MS(docNames[(int) (Math.random() * docNames.length)], (int) (Math.random() * 10)));
            doctors.addDoc(new MS(docNames[(int) (Math.random() * docNames.length)], (int) (Math.random() * 10)));
            doctors.addDoc(new SS(docNames[(int) (Math.random() * docNames.length)], (int) (Math.random() * 10)));
        } else if (template.equals("Set 4")) {
            doctors.addDoc(new ES(docNames[(int) (Math.random() * docNames.length)], (int) (Math.random() * 10)));
            doctors.addDoc(new ES(docNames[(int) (Math.random() * docNames.length)], (int) (Math.random() * 10)));
            doctors.addDoc(new GP(docNames[(int) (Math.random() * docNames.length)], (int) (Math.random() * 10)));
            doctors.addDoc(new GP(docNames[(int) (Math.random() * docNames.length)], (int) (Math.random() * 10)));
            doctors.addDoc(new MS(docNames[(int) (Math.random() * docNames.length)], (int) (Math.random() * 10)));
            doctors.addDoc(new SS(docNames[(int) (Math.random() * docNames.length)], (int) (Math.random() * 10)));
        }
    }

    public static void addPatients(pplList patients, String template){
        if (template.equals("Patient Set 1")) {
            patients.addPerson(new MinorCare(patientNames[(int) (Math.random() * patientNames.length)], possibleInjury[(int) (Math.random() * possibleInjury.length)], (int)(Math.random() * 50) + 1, false, "mid"));
            patients.addPerson(new MinorCare(patientNames[(int) (Math.random() * patientNames.length)], possibleInjury[(int) (Math.random() * possibleInjury.length)], (int)(Math.random() * 50) + 1, false, "mid"));
            patients.addPerson(new MinorCare(patientNames[(int) (Math.random() * patientNames.length)], possibleInjury[(int) (Math.random() * possibleInjury.length)], (int)(Math.random() * 50) + 1, false, "low"));
            patients.addPerson(new MinorCare(patientNames[(int) (Math.random() * patientNames.length)], possibleInjury[(int) (Math.random() * possibleInjury.length)], (int)(Math.random() * 50) + 1, false, "low"));
            patients.addPerson(new MinorCare(patientNames[(int) (Math.random() * patientNames.length)], possibleInjury[(int) (Math.random() * possibleInjury.length)], (int)(Math.random() * 50) + 1, false, "low"));
            patients.addPerson(new MinorCare(patientNames[(int) (Math.random() * patientNames.length)], possibleInjury[(int) (Math.random() * possibleInjury.length)], (int)(Math.random() * 50) + 1, false, "low"));
            patients.addPerson(new MinorCare(patientNames[(int) (Math.random() * patientNames.length)], possibleInjury[(int) (Math.random() * possibleInjury.length)], (int)(Math.random() * 50) + 1, false, "high"));
            patients.addPerson(new MinorCare(patientNames[(int) (Math.random() * patientNames.length)], possibleInjury[(int) (Math.random() * possibleInjury.length)], (int)(Math.random() * 50) + 1, false, "high"));
            patients.addPerson(new MinorCare(patientNames[(int) (Math.random() * patientNames.length)], possibleInjury[(int) (Math.random() * possibleInjury.length)], (int)(Math.random() * 50) + 1, false, "high"));
            patients.addPerson(new MinorCare(patientNames[(int) (Math.random() * patientNames.length)], possibleInjury[(int) (Math.random() * possibleInjury.length)], (int)(Math.random() * 50) + 1, false, "low"));
            patients.addPerson(new MinorCare(patientNames[(int) (Math.random() * patientNames.length)], possibleInjury[(int) (Math.random() * possibleInjury.length)], (int)(Math.random() * 50) + 1, false, "low"));


        } else if (template.equals("Patient Set 2")) {
            patients.addPerson(new MinorCare(patientNames[(int) (Math.random() * patientNames.length)], possibleInjury[(int) (Math.random() * possibleInjury.length)], (int)(Math.random() * 50) + 1, false, "mid"));
            patients.addPerson(new MinorCare(patientNames[(int) (Math.random() * patientNames.length)], possibleInjury[(int) (Math.random() * possibleInjury.length)], (int)(Math.random() * 50) + 1, false, "high"));
            patients.addPerson(new MinorCare(patientNames[(int) (Math.random() * patientNames.length)], possibleInjury[(int) (Math.random() * possibleInjury.length)], (int)(Math.random() * 50) + 1, false, "mid"));
            patients.addPerson(new MinorCare(patientNames[(int) (Math.random() * patientNames.length)], possibleInjury[(int) (Math.random() * possibleInjury.length)], (int)(Math.random() * 50) + 1, false, "mid"));
            patients.addPerson(new MinorCare(patientNames[(int) (Math.random() * patientNames.length)], possibleInjury[(int) (Math.random() * possibleInjury.length)], (int)(Math.random() * 50) + 1, false, "mid"));
            patients.addPerson(new MinorCare(patientNames[(int) (Math.random() * patientNames.length)], possibleInjury[(int) (Math.random() * possibleInjury.length)], (int)(Math.random() * 50) + 1, false, "low"));
            patients.addPerson(new MinorCare(patientNames[(int) (Math.random() * patientNames.length)], possibleInjury[(int) (Math.random() * possibleInjury.length)], (int)(Math.random() * 50) + 1, false, "high"));
            patients.addPerson(new MinorCare(patientNames[(int) (Math.random() * patientNames.length)], possibleInjury[(int) (Math.random() * possibleInjury.length)], (int)(Math.random() * 50) + 1, false, "high"));
            patients.addPerson(new MinorCare(patientNames[(int) (Math.random() * patientNames.length)], possibleInjury[(int) (Math.random() * possibleInjury.length)], (int)(Math.random() * 50) + 1, false, "high"));
            patients.addPerson(new MinorCare(patientNames[(int) (Math.random() * patientNames.length)], possibleInjury[(int) (Math.random() * possibleInjury.length)], (int)(Math.random() * 50) + 1, false, "low"));
            patients.addPerson(new MinorCare(patientNames[(int) (Math.random() * patientNames.length)], possibleInjury[(int) (Math.random() * possibleInjury.length)], (int)(Math.random() * 50) + 1, false, "mid"));
        } else if (template.equals("Patient Set 3")) {
            patients.addPerson(new MinorCare(patientNames[(int) (Math.random() * patientNames.length)], possibleInjury[(int) (Math.random() * possibleInjury.length)], (int)(Math.random() * 50) + 1, false, "mid"));
            patients.addPerson(new MinorCare(patientNames[(int) (Math.random() * patientNames.length)], possibleInjury[(int) (Math.random() * possibleInjury.length)], (int)(Math.random() * 50) + 1, false, "low"));
            patients.addPerson(new MinorCare(patientNames[(int) (Math.random() * patientNames.length)], possibleInjury[(int) (Math.random() * possibleInjury.length)], (int)(Math.random() * 50) + 1, false, "low"));
            patients.addPerson(new MinorCare(patientNames[(int) (Math.random() * patientNames.length)], possibleInjury[(int) (Math.random() * possibleInjury.length)], (int)(Math.random() * 50) + 1, false, "low"));
            patients.addPerson(new MinorCare(patientNames[(int) (Math.random() * patientNames.length)], possibleInjury[(int) (Math.random() * possibleInjury.length)], (int)(Math.random() * 50) + 1, false, "high"));
            patients.addPerson(new MinorCare(patientNames[(int) (Math.random() * patientNames.length)], possibleInjury[(int) (Math.random() * possibleInjury.length)], (int)(Math.random() * 50) + 1, false, "low"));
            patients.addPerson(new MinorCare(patientNames[(int) (Math.random() * patientNames.length)], possibleInjury[(int) (Math.random() * possibleInjury.length)], (int)(Math.random() * 50) + 1, false, "mid"));
            patients.addPerson(new MinorCare(patientNames[(int) (Math.random() * patientNames.length)], possibleInjury[(int) (Math.random() * possibleInjury.length)], (int)(Math.random() * 50) + 1, false, "mid"));
            patients.addPerson(new MinorCare(patientNames[(int) (Math.random() * patientNames.length)], possibleInjury[(int) (Math.random() * possibleInjury.length)], (int)(Math.random() * 50) + 1, false, "high"));
            patients.addPerson(new MinorCare(patientNames[(int) (Math.random() * patientNames.length)], possibleInjury[(int) (Math.random() * possibleInjury.length)], (int)(Math.random() * 50) + 1, false, "high"));
            patients.addPerson(new MinorCare(patientNames[(int) (Math.random() * patientNames.length)], possibleInjury[(int) (Math.random() * possibleInjury.length)], (int)(Math.random() * 50) + 1, false, "low"));
        } else if (template.equals("Patient Set 4")) {
            patients.addPerson(new MinorCare(patientNames[(int) (Math.random() * patientNames.length)], possibleInjury[(int) (Math.random() * possibleInjury.length)], (int)(Math.random() * 50) + 1, false, "low"));
            patients.addPerson(new MinorCare(patientNames[(int) (Math.random() * patientNames.length)], possibleInjury[(int) (Math.random() * possibleInjury.length)], (int)(Math.random() * 50) + 1, false, "mid"));
            patients.addPerson(new MinorCare(patientNames[(int) (Math.random() * patientNames.length)], possibleInjury[(int) (Math.random() * possibleInjury.length)], (int)(Math.random() * 50) + 1, false, "high"));
            patients.addPerson(new MinorCare(patientNames[(int) (Math.random() * patientNames.length)], possibleInjury[(int) (Math.random() * possibleInjury.length)], (int)(Math.random() * 50) + 1, false, "mid"));
            patients.addPerson(new MinorCare(patientNames[(int) (Math.random() * patientNames.length)], possibleInjury[(int) (Math.random() * possibleInjury.length)], (int)(Math.random() * 50) + 1, false, "high"));
            patients.addPerson(new MinorCare(patientNames[(int) (Math.random() * patientNames.length)], possibleInjury[(int) (Math.random() * possibleInjury.length)], (int)(Math.random() * 50) + 1, false, "mid"));
            patients.addPerson(new MinorCare(patientNames[(int) (Math.random() * patientNames.length)], possibleInjury[(int) (Math.random() * possibleInjury.length)], (int)(Math.random() * 50) + 1, false, "high"));
            patients.addPerson(new MinorCare(patientNames[(int) (Math.random() * patientNames.length)], possibleInjury[(int) (Math.random() * possibleInjury.length)], (int)(Math.random() * 50) + 1, false, "high"));
            patients.addPerson(new MinorCare(patientNames[(int) (Math.random() * patientNames.length)], possibleInjury[(int) (Math.random() * possibleInjury.length)], (int)(Math.random() * 50) + 1, false, "high"));
            patients.addPerson(new MinorCare(patientNames[(int) (Math.random() * patientNames.length)], possibleInjury[(int) (Math.random() * possibleInjury.length)], (int)(Math.random() * 50) + 1, false, "mid"));
            patients.addPerson(new MinorCare(patientNames[(int) (Math.random() * patientNames.length)], possibleInjury[(int) (Math.random() * possibleInjury.length)], (int)(Math.random() * 50) + 1, false, "low"));
        }

        patients.sort();
    }

    public static void toCure(docList doctors, String template, pplList paitents){
        if (template.equals("Doctor 1")){
            Doctor doc = doctors.getDoc(0);
            Patient yes = (Patient) doctors.getDoc(0).getQueue().get(0);
            doc.treat((Patient) doctors.getDoc(0).getQueue().get(0));
            paitents.removePerson(yes);

        } else if (template.equals("Doctor 2")){
            Patient yes = (Patient) doctors.getDoc(1).getQueue().get(0);
            doctors.getDoc(1).treat(yes);
            paitents.removePerson(yes);

        } else if (template.equals("Doctor 3")){
            Patient yes = (Patient) doctors.getDoc(2).getQueue().get(0);
            doctors.getDoc(2).treat(yes);
            paitents.removePerson(yes);

        } else if (template.equals("Doctor 4")){
            Patient yes = (Patient) doctors.getDoc(3).getQueue().get(0);
            doctors.getDoc(3).treat((Patient) doctors.getDoc(3).getQueue().get(0));
            paitents.removePerson(yes);

        } else if (template.equals("Doctor 5")){
            Patient yes = (Patient) doctors.getDoc(4).getQueue().get(0);
            doctors.getDoc(4).treat((Patient) doctors.getDoc(4).getQueue().get(0));
            paitents.removePerson(yes);

        } else if (template.equals("Doctor 6")){
            Patient yes = (Patient) doctors.getDoc(5).getQueue().get(0);
            doctors.getDoc(5).treat((Patient) doctors.getDoc(5).getQueue().get(0));
            paitents.removePerson(yes);
        }
    }
}
