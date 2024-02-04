import java.util.*;
public class SS extends Doctor{ // Try not to add any more new private variables as that messes up other parts of the code
    // List of illness/injury that this doctor can cure (Can be changed later)
    private final String[] treatable1 = {"Cholecystitis", "Inguinal Hernia", "Appendicitis", "Coronary Artery Bypass Grafting", "Lung Cancer Resection", "Meningioma", "Lumbar Disc Herniation", "Osteoarthritis of the Knee", "Hip Fractures", "Skin Cancer Removal", "Cleft Lip and Palate Repair"};
    private ArrayList<String> treatable;

    public SS(String name, int experience)
    {
        super(name, experience);
        treatable = new ArrayList<>();
        for(String a : treatable1)
        {
            treatable.add(a);
        }
    }
    public ArrayList<String> getTreatable()
    {
        return this.treatable;
    }

    @Override
    public String treat(Patient patient) { // Treats the given patient (This will normally treat the first patient in line when sorting the patients into the right doctors properly)
        int index = getQueue().indexOf(patient);
        if(treatable.contains(patient.getInjury()))
        {
            getQueue().remove(index);
            return patient.getName() + " has recovered from " + patient.getInjury() + " by " + getName();
        }
        return patient.getName() + " can't be treated here";
    }

    @Override
    public String toString()
    {
        String result = super.toString() + "(Surgical Specialist)";
        return result;
    }
}
