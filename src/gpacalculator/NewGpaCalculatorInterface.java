package gpacalculator;
/**
 *201609
 *@author ADELE
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.TitledBorder;

public class NewGpaCalculatorInterface extends JFrame {

    private int numberOfAGrades, numberOfBGrades, numberOfBplusGrades;
    private int numberOfCGrades, numberOfCplusGrades, numberOfDGrades;
    private int numberOfDplusGrades, numberOfFGrades;
    private int numberOfGrades;
    
    // create labels
    JLabel ALabel = new JLabel("Enter number of 'A' Grades");
    JLabel BPlusLabel = new JLabel("Enter number of 'B+' Grades");
    JLabel BLabel = new JLabel("Enter number of 'B' Grades");
    JLabel CPlusLabel = new JLabel("Enter number of 'C+' Grades");
    JLabel CLabel = new JLabel("Enter number of 'C' Grades");
    JLabel DPlusLabel = new JLabel("Enter number of 'D+' Grades");
    JLabel DLabel = new JLabel("Enter number of 'D' Grades");
    JLabel FLabel = new JLabel("Enter number of 'F' Grades");
    JLabel Gpa = new JLabel("GPA");
    
    //create textfields
    JTextField AgradeTextField = new JTextField(5);
    JTextField BPlusgradeTextField = new JTextField(5);
    JTextField BgradeTextField = new JTextField(5);
    JTextField CPlusgradeTextField = new JTextField(5);
    JTextField CgradeTextField = new JTextField(5);
    JTextField DPlusgradeTextField = new JTextField(5);
    JTextField DgradeTextField = new JTextField(5);
    JTextField FgradeTextField = new JTextField(5);
    JTextField result = new JTextField(15);
    JButton submit = new JButton("COMPUTE GPA");
    
    public NewGpaCalculatorInterface() {
        //setLayout
        JPanel p1 = new JPanel (new GridLayout (8,2));
        
        //add labels and textfields to ânel p1
        p1.add(ALabel);
        p1.add(AgradeTextField);
        p1.add(BPlusLabel);
        p1.add(BPlusgradeTextField);
        p1.add(BLabel);
        p1.add(BgradeTextField);
        p1.add(CPlusLabel);
        p1.add(CPlusgradeTextField);
        p1.add(CLabel);
        p1.add(CgradeTextField);
        p1.add(DPlusLabel);
        p1.add(DPlusgradeTextField);
        p1.add(DLabel);
        p1.add(DgradeTextField);
        p1.add(FLabel);
        p1.add(FgradeTextField);
        
        p1.setBorder(new
            TitledBorder("PLEASE FILL EVERY FIELD"));
        
        JPanel p2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        p2.add(submit);
        p2.add(Gpa);
        result.setEditable(false);
        p2.add(result);

        add(p1, BorderLayout.CENTER);
        add(p2, BorderLayout.SOUTH);

        submit.addActionListener(new ButtonListener());
    }
    public class ButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            //Get values from textfields
            numberOfAGrades =
                    (int) (Double.parseDouble(AgradeTextField.getText()));
            numberOfBplusGrades =
                    (int) (Double.parseDouble(BPlusgradeTextField.getText()));
            numberOfBGrades = (int)
                    (Double.parseDouble(BgradeTextField.getText()));
            numberOfCplusGrades =
                    (int) (Double.parseDouble(CPlusgradeTextField.getText()));
            numberOfCGrades =
                    (int) (Double.parseDouble(CgradeTextField.getText()));
            numberOfDplusGrades =
                    (int) (Double.parseDouble(DPlusgradeTextField.getText()));
            numberOfDGrades =
                    (int) (Double.parseDouble(DgradeTextField.getText()));
            numberOfFGrades =
                    (int) (Double.parseDouble(FgradeTextField.getText()));

            /*if(numberOfAGrades == 0 || numberOfBGrades == 0 ||
                numberOfBplusGrades == 0 || numberOfCGrades == 0 ||
                numberOfCplusGrades == 0 ||numberOfDGrades == 0||
                numberOfDplusGrades == 0 || numberOfFGrades == 0 ||
                numberOfGrades == 0){
                submit.setEnabled(false);
            }else {submit.setEnabled(true);
            }
            */
            
            double gradepoints = (numberOfAGrades * 4.0) + (numberOfBGrades * 3.0)
                    + (numberOfBplusGrades * 3.5) + (numberOfCplusGrades * 2.5)
                    + (numberOfCGrades * 2.0) + (numberOfDplusGrades * 1.5)
                    + (numberOfDGrades * 1.0) + (numberOfFGrades * 0.0); 
            numberOfGrades = numberOfAGrades + numberOfBGrades +
                    numberOfBplusGrades + numberOfCplusGrades + numberOfCGrades +
                    numberOfDplusGrades + numberOfDGrades + numberOfFGrades;
            double gpa = gradepoints / numberOfGrades;            
            
            try{
                if (numberOfGrades <=12){
                result.setText(" " + gpa);
                } else if (numberOfGrades >= 12){
                    result.setText("Number of courses exceeded");
                }       
            } catch (Exception exc){
                // result.setText("Please Re-enter values");
            }
            JOptionPane.showMessageDialog(NewGpaCalculatorInterface.this, gpa, "Gpa", JOptionPane.PLAIN_MESSAGE);
        }
    }   
    public static void main(String[] args) {
        NewGpaCalculatorInterface calc = new NewGpaCalculatorInterface();
        calc.setTitle("GPA Calculator");
        calc.setSize(350,350);
        calc.setResizable(false);
        calc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calc.setVisible(true);
    }
}