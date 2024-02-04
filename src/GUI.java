import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    private JFrame frame;
    private JButton[] doctorList;
    private JButton[] patientsOrganizer;
    private pplList patientsList;
    private docList doctors;

    public GUI() {
        // setting up main frame and variables
        patientsList = new pplList();
        doctors = new docList();
        frame = new JFrame("Hospital Emergency Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel main = new JPanel();
        frame.getContentPane().add(main);
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));

        // creates a panel to hold button functions
        JPanel topButtons = new JPanel();
        topButtons.setLayout(new GridLayout(2, 2));

        // sets up various doctors to assist patients
        int numOfDoctors = 6;
        doctorList = new JButton[numOfDoctors];
        JPanel doctorHolder = new JPanel(new GridLayout());

        for (int i = 0; i < 6; i++){
            doctorList[i] = new JButton();;
            doctorHolder.add(doctorList[i]);
            int num = i;

            doctorList[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Doctor doc = doctors.getDoc(num);
                    String msg = "Hello, I am " + doc.getName() + ".\nI am a " + doc.getClass().getName() + " and have " + doc.getExp() + " years of experience. \nI can treat " + doc.getTreatable().toString();
                    JOptionPane.showMessageDialog(new JFrame(), msg, "Doctor Info", JOptionPane.PLAIN_MESSAGE);
                }
            });
        }

        Dimension d = doctorHolder.getPreferredSize();
        d.width = 200;
        d.height = 300;
        doctorHolder.setPreferredSize(d);


        int patientsListNum = 6;
        patientsOrganizer = new JButton[patientsListNum];
        JPanel patientsHolder = new JPanel(new GridLayout());

        for (int i = 0; i < 6; i++){
            patientsOrganizer[i] = new JButton();
            patientsHolder.add(patientsOrganizer[i]);
            int num = i;

            patientsOrganizer[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Doctor doc = doctors.getDoc(num);
                    String msg = "Patients in Queue: " + doc.getQueue();
                    JOptionPane.showMessageDialog(new JFrame(), msg, "Queue Info", JOptionPane.PLAIN_MESSAGE);

                }
            });
        }

        Dimension di = patientsHolder.getPreferredSize();
        di.width = 200;
        di.height = 100;
        patientsHolder.setPreferredSize(d);


        // a function that changes the doctors
        JButton changeDocs = new JButton("Change Doctors");
        changeDocs.addActionListener(e -> {
            changeDoctors();
        });
        topButtons.add(changeDocs);

        JButton addPatient = new JButton("Add Patient");
        addPatient.addActionListener(e -> {
            addPresetPatients();
        });
        topButtons.add(addPatient);

        JButton curePatients = new JButton("Cure Patient");
        curePatients.addActionListener(e -> {
            curePatientsInNeed();
        });
        topButtons.add(curePatients);


        // compiles and adds all major pieces of the simulation
        main.add(topButtons);
        main.add(Box.createHorizontalStrut(1024));
        main.add(doctorHolder);
        main.add(Box.createHorizontalStrut(1024));
        main.add(patientsHolder);

        frame.pack();
        frame.setSize(1024, 768);
        frame.setVisible(true);

        // tutorial / set up
        changeDoctors();
        addPresetPatients();
    }

    private void changeDoctors(){
        String[] options = {"Set 1", "Set 2", "Set 3", "Set 4"};
        String choice = (String) JOptionPane.showInputDialog(frame, "Choose a set of doctors on staff", "Menu", JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        scenarioManager.getDoctors(doctors, choice);

        for (int i = 0; i < 6; i++){
            Doctor doc = (Doctor) doctors.returnDoctors().get(i);
            doctorList[i].setText(doc.getName());

            if (doc.getClass().getName().equals("ES")) {
                doctorList[i].setBackground(Color.pink);
            } else if (doc.getClass().getName().equals("GP")) {
                doctorList[i].setBackground(Color.green);
            } else if (doc.getClass().getName().equals("MS")) {
                doctorList[i].setBackground(Color.CYAN);
            } else {
                doctorList[i].setBackground(Color.orange);
            }
        }
        handlePatients();
    }

    public void addPresetPatients(){
        String[] options = {"Patient Set 1", "Patient Set 2", "Patient Set 3", "Patient Set 4"};
        String choice = (String) JOptionPane.showInputDialog(frame, "Add selection of patients", "Menu", JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        scenarioManager.addPatients(patientsList, choice);
        handlePatients();
        changeQueueName();

    }

    public void handlePatients(){
        if (doctors.returnDoctors().size() > 0 && patientsList.size() > 0){
            doctors.pplToDoc(patientsList);
        }
    }

    public void curePatientsInNeed(){
        String[] options = {"Doctor 1", "Doctor 2", "Doctor 3", "Doctor 4", "Doctor 5", "Doctor 6"};
        String choice = (String) JOptionPane.showInputDialog(frame, "Select a doctor to cure their current patient", "Menu", JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        scenarioManager.toCure(doctors, choice, patientsList);
        handlePatients();
        changeQueueName();
        System.out.println("PK" + patientsList.size());
    }

    public void changeQueueName(){
        for (int i = 0; i < 6; i++){
            Doctor doc = (Doctor) doctors.returnDoctors().get(i);
            String que = "";
            if (!doc.getQueue().isEmpty()) {
                for (int j = 0; j < doc.getQueue().size() - 1; j++) {
                    Patient bud = (Patient) doc.getQueue().get(j);
                    que += bud.getName() + ", ";
                }
                Patient last = (Patient) doc.getQueue().get(doc.getQueue().size() - 1);
                que += last.getName();
            }
            patientsOrganizer[i].setText(que);
        }
    }

    private void showError(String message){
        JOptionPane.showMessageDialog(new JFrame(), message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void setUpGUI(){
        GUI visual = new GUI();
    }
}
