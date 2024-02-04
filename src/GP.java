import java.util.*;
public class GP extends Doctor{ // Try not to add any more new private variables as that messes up other parts of the code
    private final String[] treatable1 = {"Influenza", "Type 2 Diabetes Mellitus", "Hypertension", "Asthma", "Otitis Media", "Obesity", "Anxiety Disorders", "Depression", "Hyperlipidemia", "Allergic Rhinitis"}; // List of illness/injury that this doctor can cure (Can be changed later)
    private ArrayList<String> treatable;

    public GP(String name, int experience)
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
        String result = super.toString() + "(General Practitioner)";
        return result;
    }

}
