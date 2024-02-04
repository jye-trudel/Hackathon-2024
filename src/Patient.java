public abstract class Patient implements Comparable<Patient>{
    private String name;
    private String injury;
    private int age;
    private boolean isDead;
    private String priority; // Can be high, mid, low

    public Patient(String name, String injury, int age, boolean isDead, String priority) {
        this.name = name;
        this.injury = injury;
        this.age = age;
        this.isDead = isDead;
        this.priority = priority;
    }

    public String getName() {return name;}
    public String getInjury() {return injury;}
    public int getAge() {return age;}
    public boolean isDead() {return isDead;}
    public String getPriority(){return priority;}

    public abstract <T extends Patient> int compareTo(T patient); // Compares priority levels for collections.sort
    public String toString()
    {
        if(isDead)
        {
            return "Name: " + name + " Age: " + age + "Medical Issue: Dead";
        }
        return "Name: " + name + " Age: " + age + " Medical Issue: " + injury + " Priority: " + priority;
    }

}
