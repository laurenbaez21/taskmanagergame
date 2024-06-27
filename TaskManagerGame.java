import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class TaskManagerGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> tasks = new ArrayList<>(); // Initialize a list to store tasks

        // Display welcome messages
        System.out.println("Welcome to Task Manager Game!");
        System.out.println("Help the fairy collect fairy dust by completing tasks.");
        System.out.println("Let's begin!\n");

        System.out.println("Enter the tasks you need to complete today.");

        // Input loop to add tasks
        while (true) {
            System.out.print("Enter a task (or type 'exit' to finish): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            tasks.add(input); // Add task to the list
        }

        // Display the tasks entered by the user
        System.out.println("\nToday's Tasks:");
        for (String task : tasks) {
            System.out.println("- " + task);
        }

        // Display initial fairy dust count based on the number of tasks
        System.out.print("\nFairy Dust to Collect: ");
        displayFairy(tasks.size());

        System.out.println("\nTask Manager Game Starts!");

        int tasksCompleted = 0;
        int totalTasks = tasks.size();
        int fairyDustCount = totalTasks; // Set initial fairy dust count to the number of tasks

        // Game loop to complete tasks
        while (tasksCompleted < totalTasks) {
            System.out.println("\nChoose a task to complete:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }

            System.out.print("Enter the task number you completed: ");
            int taskNumber = scanner.nextInt();
            scanner.nextLine(); // Consume newline after reading int input

            if (taskNumber > 0 && taskNumber <= tasks.size()) {
                System.out.println("Task '" + tasks.get(taskNumber - 1) + "' completed!");
                tasks.remove(taskNumber - 1); // Remove completed task
                tasksCompleted++;

                // Show fairy collecting fairy dust
                fairyDustCount--;
                displayFairy(fairyDustCount);
            } else {
                System.out.println("Invalid task number. Try again.");
            }
        }

        // All tasks completed, display celebration
        displayCelebration();
        scanner.close(); // Close the scanner
    }

    // Method to display the fairy and collected fairy dust
    public static void displayFairy(int dustToCollect) {
        System.out.print("🧚‍♀️"); // Unicode escape sequence for the fairy emoji
        String dust = "✨"; // Sparkles emoji codepoint
        for (int i = 0; i < dustToCollect; i++) {
            System.out.print(dust + " ");
        }
        System.out.println();
    }

    // Method to display the celebration message
    public static void displayCelebration() {
        System.out.println("\nCongratulations on finishing all tasks!");
        System.out.println("……….                             ");
        System.out.println("……………….......                    ");
        System.out.println("……       ✨           …            ");
        System.out.println("…    ✨                ✨     ….     ");
        System.out.println("…            𝐜𝐨𝐧𝐠𝐫𝐚𝐭𝐳            ……");
        System.out.println("……            👏    🎉   👍           ………");
        System.out.println("…✨          ◝(ᵔᵕᵔ)◜     ✨   ……     ");
        System.out.println("…                                 ……. ");
        System.out.println("…        ✨        ….             ");
        System.out.println("……………....                        ");
        System.out.println("…….                              ");
    }
}
