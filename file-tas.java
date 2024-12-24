import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BugTrackingSystem {
    private List<Bug> bugs;

    public BugTrackingSystem() {
        bugs = new ArrayList<>();
    }

    public void addBug(Bug bug) {
        bugs.add(bug);
    }

    public void displayBugs() {
        for (Bug bug : bugs) {
            System.out.println(bug);
        }
    }

    public void modifyBugStatus(int bugId, String newStatus) {
        for (Bug bug : bugs) {
            if (bug.getId() == bugId) {
                bug.setStatus(newStatus);
                break;
            }
        }
    }

    public static void main(String[] args) {
        BugTrackingSystem bugTracker = new BugTrackingSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter 1 to add a bug, 2 to display bugs, 3 to modify bug status, or 0 to exit:");
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.println("Enter bug ID:");
                int bugId = scanner.nextInt();
                System.out.println("Enter bug description:");
                String description = scanner.next();
                System.out.println("Enter bug status:");
                String status = scanner.next();
                System.out.println("Enter bug priority:");
                int priority = scanner.nextInt();

                Bug bug = new Bug(bugId, description, status, priority);
                bugTracker.addBug(bug);
            } else if (choice == 2) {
                bugTracker.displayBugs();
            } else if (choice == 3) {
                System.out.println("Enter bug ID:");
                int bugId = scanner.nextInt();
                System.out.println("Enter new bug status:");
                String newStatus = scanner.next();

                bugTracker.modifyBugStatus(bugId, newStatus);
            } else if (choice == 0) {
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}

class Bug {
    private int id;
    private String description;
    private String status;
    private int priority;

    public Bug(int id, String description, String status, int priority) {
        this.id = id;
        this.description = description;
        this.status = status;
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public int getPriority() {
        return priority;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Bug{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", priority=" + priority +
                '}';
    }
}