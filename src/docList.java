import java.util.*;
public class docList<T extends Doctor>{
    private ArrayList<T> doctors;

    public docList()
    {
        doctors = new ArrayList<>();
    }

    public void addDoc(T doctor)
    {
        if(!doctors.contains(doctor))
        {
            doctors.add(doctor);
        }
    }

    public ArrayList<T> returnDoctors(){
        return doctors;
    }

    public T removeDoc(T doctor)
    {
        if(doctors.contains(doctor))
        {
            doctors.remove(doctor);
            return doctor;
        }
        System.out.println("No such doctor exists");
        return null;
    }

    public T getDoc(int num)
    {
        if(num < doctors.size())
        {
            return doctors.get(num);
        }
        else
        {
            System.out.println("No such doctor exists");
            return null;
        }
    }

    public <P extends Patient> void pplToDoc(pplList<P> listOfPpl) // Sorts a list of sick people to the corresponding doctors in doctor list
    {
        ArrayList<P> list = listOfPpl.getList(); // Gets the exact list from listOfPpl
        for(int i = 0 ; i < list.size() ; i++) // Loops through all the patients (Not caring about priority as pplList has sorting algorithm already so this is all assuming its already sorted)
        {
            P curr = list.get(i); // Current patient element
            int indexOfLeastBusy = Integer.MAX_VALUE; // Tracking the index of the doctor that is MOST available currently
            int leastBusy = Integer.MAX_VALUE; // Tracking the number of patients that the least busy doctor has
            for(int j = 0 ; j < doctors.size() ; j++) // Looping all doctors to find one least busy doctor
            {
                T currDoc = doctors.get(j); // Current doctor element
                if(currDoc.getTreatable().contains(curr.getInjury())) // If the current doctor can treat the following patient then proceed
                {
                    if(currDoc.getQueue().size() < leastBusy) // Checking if the patient queue behind the current doctor
                    {
                        indexOfLeastBusy = j; // Updating the index of the doctor that is most available
                        leastBusy = currDoc.getQueue().size(); // Updates the leastBusy to the patient queue of the least busy doctor
                    }
                }
            }
            doctors.get(indexOfLeastBusy).addPatient(curr); // Updates the doctors list
        }
    }

    public String toString()
    {
        String result = "";
        if(!doctors.isEmpty())
        {
            for(T doctor : doctors)
            {
                result += doctor.toString() + "\n";
            }
            return result;
        }
        return result;
    }
}
