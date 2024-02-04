public class UrgentCare extends Patient{
    public UrgentCare(String name, String injury, int age, boolean isDead, String priority) {
        super(name, injury, age, isDead, priority);
    }
    @Override
    public int compareTo(Patient patient)
    {
        if(this.getPriority().equalsIgnoreCase("high"))
        {
            if(patient.getPriority().equalsIgnoreCase("mid") || patient.getPriority().equalsIgnoreCase("low"))
            {
                return -1;
            }
            else
            {
                return 0;
            }
        }
        if(this.getPriority().equalsIgnoreCase("mid"))
        {
            if(patient.getPriority().equalsIgnoreCase("high"))
            {
                return 1;
            }
            if(patient.getPriority().equalsIgnoreCase("low"))
            {
                return -1;
            }
            else
            {
                return 0;
            }
        }
        if(this.getPriority().equalsIgnoreCase("low"))
        {
            if(patient.getPriority().equalsIgnoreCase("high") || patient.getPriority().equalsIgnoreCase("mid"))
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }
        return 0;
    }
}
