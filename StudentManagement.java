import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

class Student implements Serializable {
    private int rollNumber;
    private String name;
    private String grade;

    public Student(int rollNumber, String name, String grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.grade = grade;
    }

   public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Roll Number: " + rollNumber + ", Name: " + name + ", Grade: " + grade;
    }
}

class StudentManagementSystem {
    private List<Student> students;

    public StudentManagementSystem() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    public Student searchStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                return student;
            }
        }
        return null; // Student not found
    }

    public List<Student> getAllStudents() {
        return students;
    }
}

public class StudentManagement {
    private StudentManagementSystem sms;
    private JFrame frame;
    private JTextField rollNumberField, nameField, gradeField;
    private JTextArea outputArea;

    public StudentManagement() {
        sms = new StudentManagementSystem();
        frame = new JFrame("Student Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);

        JLabel rollNumberLabel = new JLabel("Roll Number:");
        rollNumberField = new JTextField(30);
         rollNumberField.setPreferredSize(new Dimension(200, 30));

        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField(30);
                nameField.setPreferredSize(new Dimension(300, 30)); // Adjusted preferred size


        JLabel gradeLabel = new JLabel("Grade:");
        gradeField = new JTextField(30);
                gradeField.setPreferredSize(new Dimension(100, 30)); // Adjusted preferred size


        JButton addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int rollNumber = Integer.parseInt(rollNumberField.getText());
                    String name = nameField.getText();
                    String grade = gradeField.getText();
                    sms.addStudent(new Student(rollNumber, name, grade));
                    outputArea.append("Student added successfully!\n");
                } catch (NumberFormatException ex) {
                    outputArea.append("Invalid Roll Number!\n");
                }
                clearFields();
            }
        });

        JButton removeButton = new JButton("Remove");
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int rollNumber = Integer.parseInt(rollNumberField.getText());
                    removeStudent(rollNumber);
                } catch (NumberFormatException ex) {
                    outputArea.append("Invalid Roll Number!\n");
                }
                clearFields();
            }
        });

        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int rollNumber = Integer.parseInt(rollNumberField.getText());
                    searchStudent(rollNumber);
                } catch (NumberFormatException ex) {
                    outputArea.append("Invalid Roll Number!\n");
                }
                clearFields();
            }
        });

        JButton displayAllButton = new JButton("Display All");
        displayAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayAllStudents();
                clearFields();
            }
        });

        constraints.gridx = 0;
        constraints.gridy = 0;
        inputPanel.add(rollNumberLabel, constraints);

        constraints.gridx = 1;
        inputPanel.add(rollNumberField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        inputPanel.add(nameLabel, constraints);

        constraints.gridx = 1;
        inputPanel.add(nameField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        inputPanel.add(gradeLabel, constraints);

        constraints.gridx = 1;
        inputPanel.add(gradeField, constraints);

        constraints.gridx = 1;
        constraints.gridy = 3;
        inputPanel.add(addButton, constraints);

        constraints.gridx = 2;
        inputPanel.add(removeButton, constraints);

        constraints.gridx = 3;
        inputPanel.add(searchButton, constraints);

        constraints.gridx = 4;
        inputPanel.add(displayAllButton, constraints);

        frame.add(inputPanel, BorderLayout.NORTH);

        outputArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(outputArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    private void clearFields() {
        rollNumberField.setText("");
        nameField.setText("");
        gradeField.setText("");
    }

    private void removeStudent(int rollNumber) {
        Student studentToRemove = sms.searchStudent(rollNumber);
        if (studentToRemove != null) {
            sms.removeStudent(studentToRemove);
            outputArea.append("Student removed successfully!\n");
        } else {
            outputArea.append("Student not found!\n");
        }
    }

    private void searchStudent(int rollNumber) {
        Student foundStudent = sms.searchStudent(rollNumber);
        if (foundStudent != null) {
            outputArea.append("Student found: " + foundStudent + "\n");
        } else {
            outputArea.append("Student not found!\n");
        }
    }

    private void displayAllStudents() {
        List<Student> students = sms.getAllStudents();
        for (Student student : students) {
            outputArea.append(student.toString() + "\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new StudentManagement();
            }
        });
    }
}
