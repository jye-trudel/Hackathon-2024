import java.util.*;
public  class pplList<T extends Patient>{
    private ArrayList<T> list; // Tracks all patients in the hospital

    public pplList()
    {
        list = new ArrayList<>();
    }
    public void addPerson(T patient)
    {
        list.add(patient);
    }

    public T removePerson(T patient)
    {
        for(int i = 0 ; i < list.size() ; i++)
        {
            if(list.get(i) == patient)
            {
                T temp = list.get(i);
                list.remove(i);
                return temp;
            }
        }
        return null;
    }

    public void sort()
    {
        Collections.sort(list);
    }

    public ArrayList<T> getList()
    {
        return this.list;
    }

    public int size()
    {
        return list.size();
    }

//    public <D extends Doctor> void catagorize(ArrayList<D> Dlist){
//        for(int i = 0; i < list.size(); i++){
//            Patient curr = list.get(i);
//            for(int j = 0 ; j < Dlist.size() ; j++)
//            {
//                if(Dlist.get(j).getTreatable().contains(curr.getInjury()))
//                {
//                    Dlist.get(j).addPatient(curr);
//                }
//            }
//        }
//    }


    public String toString()
    {
        String result = "";
        for(T patient : list)
        {
            result += patient + "\n";
        }
        return result;
    }
}
