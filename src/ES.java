import java.util.*;
public class ES extends Doctor { // Try not to add any more new private variables as that messes up other parts of the code
    private static final String[] treatable1 = {"Acute Myocardial Infarction", "Acute Respiratory Distress Syndrome", "Traumatic Brain Injury", "Sepsis", "Polytrauma"}; // List of illness/injury that this doctor can cure (Can be changed later)//
    private static ArrayList<String> treatable;
    private static ArrayList<Patient> allPatient = new ArrayList<>();
    private static ArrayList<ES> esList = new ArrayList<>();
    private static int totalDoctors = 0;

    public ES(String name, int experience) {
        super(name, experience);
        treatable = new ArrayList<>();
        for(String a : treatable1) {
            treatable.add(a);
        }
        esList = new ArrayList<>();
        esList.add(this);
        totalDoctors++;
    }

    public int getTotalDoctors()
    {
        return totalDoctors;
    }
    public ArrayList<String> getTreatable() {
        return treatable;
    }
    public static ArrayList<Patient> getAllPatient() {
        return allPatient;
    }

    @Override
    public String treat(Patient patient) // Treats the given patient (This will normally treat the first patient in line when sorting the patients into the right doctors properly)
    {
        int index = getQueue().indexOf(patient);
        if (treatable.contains(patient.getInjury())) {
            getQueue().remove(index);
            return patient.getName() + " has recovered from " + patient.getInjury() + " by " + getName();
        }
        return patient.getName() + " can't be treated here";
    }

    @Override
    public String toString()
    {
        String result = super.toString() + "(Emergency Specialist)";
        return result;
    }

}