import java.util.ArrayList;

public abstract class Doctor<T extends Patient> {
    private String name;
    private int experience;
    private ArrayList<T> queue; // A list of patients that each doctor is serving

    public Doctor()
    {
        this.name = "Docter";
        this.experience = 0;
        queue = new ArrayList<>();
    }

    public Doctor(String name)
    {
        this.name = name;
        this.experience = 0;
        queue = new ArrayList<>();
    }

    public Doctor(String name, int experience)
    {
        this.name = name;
        this.experience = experience;
        queue = new ArrayList<>();
    }

    public void addQueue(ArrayList<T> list){
        queue = list;
    }

    public String getName()
    {
        return this.name;
    }

    public int getExp()
    {
        return this.experience;
    }
    public ArrayList<T> getQueue() { return this.queue; }

    public abstract String treat(T patient); // Removes a patient from the queue after treating them
    public abstract ArrayList<String> getTreatable();

    public String toString() // Returns a format that shows doctor info, and current and queued patients
    {
        if(!queue.isEmpty())
        {
            String result = "Name: " + name + " Experience: " + experience + " Years Current Patient: " + queue.get(0).getName() + " Queue:";
            for(int i = 0 ; i < queue.size() ; i++)
            {
                result += " " + queue.get(i).getName();
            }
            result += " ";
            return result;
        }
        return "Name: " + name + " Experience: " + experience + " Years Current Patient: None ";
    }

    public void addPatient(T patient) // Adds a patient into the queue
    {
        if(queue.indexOf(patient) == -1)
        {
            queue.add(patient);
        }
        else
        {
            System.out.println("Duplicate Patient");
        }
    }

    public void removePatient(T patient) // Removes a patient from the queue without treating them
    {
        if(queue.indexOf(patient) != -1)
        {
            int index = queue.indexOf(patient);
            queue.remove(index);
        }
    }
}
