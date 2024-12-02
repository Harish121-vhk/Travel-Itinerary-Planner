import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Destination> itinerary = new ArrayList<>();
        String source = "";
        double totalBudget = 0;

        System.out.println("Welcome to the Travel Itinerary Planner!");

        System.out.print("Enter your source location: ");
        source = scanner.nextLine();

        boolean running = true;

        while (running) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add Destination");
            System.out.println("2. View Itinerary");
            System.out.println("3. Calculate Total Budget");
            System.out.println("4. Show Route on Map with Distances");
            System.out.println("5. Get Weather Information");
            System.out.println("6. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter destination name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter travel date (YYYY-MM-DD): ");
                    String date = scanner.nextLine();
                    double estimatedBudget = getEstimatedBudget(name);
                    itinerary.add(new Destination(name, date, estimatedBudget));
                    totalBudget += estimatedBudget; 
                    
                    break;

                case 2:
                    if (itinerary.isEmpty()) {
                        System.out.println("No destinations added yet.");
                    } else {
                        System.out.println("Your Itinerary:");
                        for (Destination dest : itinerary) {
                            System.out.println(dest);
                        }
                    }
                    break;

                case 3:
                    System.out.println("Total Budget for the trip: $" + totalBudget);
                    break;

                case 4:
                    if (!itinerary.isEmpty()) {
                        System.out.println("Your Travel Route with Distances:");
                        for (Destination dest : itinerary) {
                            double distance = getMockDistance(source, dest.getName());
                            System.out.println("From " + source + " to " + dest.getName() + " - " + distance + " km");
                        }
                    } else {
                        System.out.println("Add at least one destination to view distances.");
                    }
                    break;

                case 5:
                    if (!itinerary.isEmpty()) {
                        System.out.println("Fetching Weather Information:");
                        for (Destination dest : itinerary) {
                            System.out.println("Destination: " + dest.getName() + " (Weather: " + getMockWeather(dest.getName()) + ")");
                        }
                    } else {
                        System.out.println("No destinations added to fetch weather information.");
                    }
                    break;

                case 6:
                    running = false;
                    System.out.println("Thank you for using the Travel Itinerary Planner!");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }

    private static double getMockDistance(String source, String destination) {
        
        return Math.random() * 500 + 50; 
    }

    private static String getMockWeather(String destination) {
        
        return "Sunny, 25°C";
    }

    private static double getEstimatedBudget(String destination) {
        
        switch (destination.toLowerCase()) {
            case "paris":
                return 1500;
            case "new york":
                return 2000;
            case "tokyo":
                return 1800;
            case "london":
                return 1600;
            case "sydney":
                return 1700;
            default:
                return 1200; 
        }
    }
}

class Destination {
    private String name;
    private String date;
    private double budget;

    public Destination(String name, String date, double budget) {
        this.name = name;
        this.date = date;
        this.budget = budget;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public double getBudget() {
        return budget;
    }

    @Override
    public String toString() {
        return "Destination: " + name + ", Date: " + date + ", Budget: $" + budget;
    }
}

