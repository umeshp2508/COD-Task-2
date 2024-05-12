import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeManager {
    private static ArrayList<Double> grades = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Student Grade Manager");

        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1. Add a grade");
            System.out.println("2. Edit a grade");
            System.out.println("3. Delete a grade");
            System.out.println("4. Calculate average grade");
            System.out.println("5. View all grades");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addGrade(scanner);
                    break;
                case 2:
                    editGrade(scanner);
                    break;
                case 3:
                    deleteGrade(scanner);
                    break;
                case 4:
                    calculateAverageGrade();
                    break;
                case 5:
                    viewAllGrades();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private static void addGrade(Scanner scanner) {
        System.out.print("Enter the grade: ");
        double grade = scanner.nextDouble();
        grades.add(grade);
        System.out.println("Grade added successfully.");
    }

    private static void editGrade(Scanner scanner) {
        if (grades.isEmpty()) {
            System.out.println("No grades to edit.");
            return;
        }

        System.out.println("Current grades:");
        for (int i = 0; i < grades.size(); i++) {
            System.out.println((i + 1) + ". " + grades.get(i));
        }

        System.out.print("Enter the index of the grade to edit: ");
        int index = scanner.nextInt() - 1;

        if (index < 0 || index >= grades.size()) {
            System.out.println("Invalid index!");
            return;
        }

        System.out.print("Enter the new grade: ");
        double newGrade = scanner.nextDouble();
        grades.set(index, newGrade);
        System.out.println("Grade updated successfully.");
    }

    private static void deleteGrade(Scanner scanner) {
        if (grades.isEmpty()) {
            System.out.println("No grades to delete.");
            return;
        }

        System.out.println("Current grades:");
        for (int i = 0; i < grades.size(); i++) {
            System.out.println((i + 1) + ". " + grades.get(i));
        }

        System.out.print("Enter the index of the grade to delete: ");
        int index = scanner.nextInt() - 1;

        if (index < 0 || index >= grades.size()) {
            System.out.println("Invalid index!");
            return;
        }

        grades.remove(index);
        System.out.println("Grade deleted successfully.");
    }

    private static void calculateAverageGrade() {
        if (grades.isEmpty()) {
            System.out.println("No grades to calculate average.");
            return;
        }

        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        double average = sum / grades.size();
        System.out.println("Average grade: " + average);
    }

    private static void viewAllGrades() {
        if (grades.isEmpty()) {
            System.out.println("No grades to display.");
            return;
        }

        System.out.println("All grades:");
        for (int i = 0; i < grades.size(); i++) {
            System.out.println((i + 1) + ". " + grades.get(i));
        }
    }
}
