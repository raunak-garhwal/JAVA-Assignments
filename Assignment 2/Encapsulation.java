// Encapsulation: Write a Java program to create a class Student with private fields for name, age, and grade. Provide public getter and setter methods for each field. Ensure that the age and grade are within a valid range (e.g., age between 5 and 25, grade between 1 and 10).

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {

    private String name;
    private int age;
    private int grade;

    // Method to set name with validation to allow only real names
    public void setName(String name) {
        // Regular expression to match names containing only letters, spaces, hyphens, and apostrophes
        if (name.matches("[a-zA-Z\\s'-]+")) {
            this.name = name;
        } else {
            System.out.println("Invalid name. Please enter a name with only letters and valid characters.");
        }
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void displayDetails() {
        System.out.println("Name of the student: " + this.name);
        System.out.println("Age of the student: " + this.age);
        System.out.println("Grade of the student: " + this.grade);
    }

    public String getName() {
        return this.name;
    }
}

public class Encapsulation {

    public static void main(String[] args) {
        Scanner myobj = new Scanner(System.in);
        List<Student> students = new ArrayList<>(); // List to store multiple Student objects

        while (true) {
            System.out.println("\n<--- MENU DRIVEN PROGRAM --->");
            System.out.println("Press 1 for registering a new student.");
            System.out.println("Press 2 for getting student information.");
            System.out.println("Press 3 to exit.");

            int choice = getValidIntegerInput(myobj, "\nEnter your choice: ");

            switch (choice) {
                case 1 -> {
                    Student s1 = new Student();
                    System.out.println("\n<---Enter the Student Details--->");
                    while (true) {
                        System.out.print("\nEnter the name of the student: ");
                        String name = myobj.next();
                        s1.setName(name);
                        if (s1.getName() != null) { // Check if name was set successfully
                            break;
                        }
                    }

                    while (true) {
                        int age = getValidIntegerInput(myobj, "Enter the age of the student: ");
                        if (age >= 5 && age <= 25) {
                            s1.setAge(age);
                            break;
                        } else {
                            System.out.println("\nPlease enter the age between 5 and 25...");
                        }
                    }

                    while (true) {
                        int grade = getValidIntegerInput(myobj, "Enter the grade of the student: ");
                        if (grade >= 1 && grade <= 10) {
                            s1.setGrade(grade);
                            break;
                        } else {
                            System.out.println("Please enter the grade between 1 and 10...");
                        }
                    }

                    // Add the student to the list
                    students.add(s1);
                    System.out.println("Student registered successfully!");
                }

                case 2 -> {
                    if (students.isEmpty()) {
                        System.out.println("WARNING: No students registered yet...");
                    } else {
                        System.out.println("\n<---Student Details--->");
                        System.out.print("\nEnter the name of the student (or press Enter to list all): ");
                        myobj.nextLine(); // Consume the newline left by nextInt()
                        String userName = myobj.nextLine();

                        if (userName.isEmpty()) {
                            // If user presses Enter, display all students
                            System.out.println("\nListing all registered students:");
                            for (Student student : students) {
                                student.displayDetails();
                                System.out.println();
                            }
                        } else {
                            // Find and display student details by name
                            boolean found = false;
                            for (Student student : students) {
                                if (student.getName().equalsIgnoreCase(userName)) {
                                    student.displayDetails();
                                    found = true;
                                    break;
                                }
                            }

                            if (!found) {
                                System.out.println("No student registered with this name.");
                            }
                        }
                    }
                }

                case 3 -> {
                    System.out.println("\nThanks for using this program......Please come back soon......");
                    myobj.close();
                    return;
                }

                default -> System.out.println("\nPlease enter a valid choice.");
            }
        }
    }

    // Method to get valid integer input with prompt
    private static int getValidIntegerInput(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                System.out.println("Invalid input. Please enter an integer value.");
                scanner.next(); // Consume the invalid input
            }
        }
    }
}
