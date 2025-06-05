import java.awt.event.*;
import javax.swing.*;
import java.util.*;

class Student 
{
    int regno;
    String name;

    public String toString() 
    {
        return "( " + regno + ", " + name + ")";
    }

    public Student(int r, String s) 
    {
        regno = r;
        name = s;
    }
}

public class StudentDB extends JFrame implements ActionListener 
{
    ArrayList<Student> list;
    int numberofstudents, ctposition;

    JButton b1, b2, b3, b4, b5, b6;
    JTextArea ta;
    JLabel l1, l2;
    JTextField t1, t2;

    Scanner sc;

    Student s;

    public StudentDB() 
    {
        l1 = new JLabel("REG NO");
        t1 = new JTextField(10);
        l2 = new JLabel("NAME");
        t2 = new JTextField(20);
        b1 = new JButton("    Insert     ");
        b2 = new JButton("<<");
        b3 = new JButton("<");
        b4 = new JButton(">");
        b5 = new JButton(">>");
        b6 = new JButton("    Search    ");
        ta = new JTextArea("Student Information \n", 10, 30);

        list = new ArrayList<Student>();
        
        l1.setBounds(40, 50, 100, 25); // Label for REG NO
        t1.setBounds(100, 50, 150, 25); // Text field for REG NO
        l2.setBounds(40, 90, 100, 25); // Label for NAME
        t2.setBounds(100, 90, 150, 25); // Text field for NAME
  
        b1.setBounds(60, 150, 100, 30); // Button Insert
        b6.setBounds(200, 150, 100, 30); // Button Search

        ta.setBounds(40, 220, 300, 200);

        add(l1); 
        add(t1);
        add(l2); 
        add(t2);
        add(b1);
        add(b6);
        add(b2);
        add(b3);
        add(b4);
        add(b5);
        add(ta);

        b1.addActionListener(this); // Insert Button
        b2.addActionListener(this); // <<
        b3.addActionListener(this); // <
        b4.addActionListener(this); // >
        b5.addActionListener(this); // >>
        b6.addActionListener(this); // Search

        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 500); 
    }

    void insert() 
    {
        int regno = Integer.parseInt(t1.getText());
        String name = t2.getText();
        s = new Student(regno, name);
        
        numberofstudents++;
        list.add(s);
        
        display();
    }

    void display() 
    {
        ta.setText("Student information\n");     
        
        for (int i = 0; i < numberofstudents; i++) 
        {   
            s = list.get(i);
            String str = s.toString();
            ta.append(str + "\n");
        }
        
        ctposition = numberofstudents - 1;
    }

    void displayfirst() 
    {
        ctposition = 0;
        
        ta.setText("Student information\n"); 
        s = list.get(0);
        
        String str = s.toString();
        ta.append(str + "\n");
    }

    void displaylast() 
    {
        ctposition = numberofstudents - 1;
        
        ta.setText("Student information\n"); 
        s = list.get(numberofstudents - 1);
        
        String str = s.toString();
        ta.append(str + "\n");
    }

    void displaynext() 
    {
        ctposition++;
        
        if (ctposition == numberofstudents) 
        {
            ctposition = 0;
        }
        
        ta.setText("Student information\n"); 
        s = list.get(ctposition);

        String str = s.toString();
        ta.append(str + "\n");
    }

    void displaypre() 
    {
        ctposition--;

        if (ctposition == -1) 
        {
            ctposition = numberofstudents - 1;
        }
        
        ta.setText("Student information\n"); 
        s = list.get(ctposition);

        String str = s.toString();
        ta.append(str + "\n");
    }

    void search() 
    {   
        ctposition = 0;

        ta.setText("Student information\n");
        
        int flag = 0;
        int regno = Integer.parseInt(t1.getText());  
        
        for (int i = 0; i < numberofstudents; i++) 
        {   
            s = list.get(i);

            if (s.regno == regno) 
            {
                String str = s.toString();
                ta.append(str + "\n");

                flag = 1;
                ctposition = i;

                break;
            }
        }
         
        if (flag == 0) 
        {
            ta.setText("Student information not found\n");
        }
    }    

    public void actionPerformed(ActionEvent e) 
    {

        if (e.getSource() == b1) 
        {
            insert();
        }
         
        if (e.getSource() == b6) 
        {
            search();
        }
         
        if (e.getSource() == b2) 
        {
            displayfirst();
        }
         
        if (e.getSource() == b5) 
        {
            displaylast();
        }
         
        if (e.getSource() == b3) 
        {
            displaypre();
        }
         
        if (e.getSource() == b4) 
        {
            displaynext();
        }

    }

    public static void main(String args[]) 
    {
        StudentDB obj = new StudentDB();
    }

}
