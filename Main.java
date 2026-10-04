public class Main {
    public static void main(String[] args) {
        NavigationSystem system = new NavigationSystem();

        Location dallas = new Location(1, "Dallas", 32.7767, -96.7970);
        Location richardson = new Location(2, "Richardson", 32.9483, -96.7299);
        Location plano = new Location(3, "Plano", 33.0198, -96.6989);
        Location royseCity = new Location(4, "Royse City", 32.9751, -96.3327);

        System.out.println("=== ADD LOCATIONS ===");
        system.addLocation(dallas);
        system.addLocation(richardson);
        system.addLocation(plano);
        system.addLocation(royseCity);

        System.out.println();
        System.out.println("=== SHOW LOCATIONS ===");
        system.showLocations();

        System.out.println();
        System.out.println("=== FIND LOCATION ===");
        Location found = system.findLocation(3);
        System.out.println(found != null
                ? "Location found: " + found.getName()
                : "Location not found.");

        System.out.println();
        System.out.println("=== VISIT LOCATIONS ===");
        system.visitLocation(1);
        system.visitLocation(2);
        system.visitLocation(3);

        System.out.println();
        System.out.println("=== GO BACK ===");
        system.goBack();
        system.goBack();

        System.out.println();
        System.out.println("=== TRAVEL HISTORY ===");
        system.showHistory();

        System.out.println();
        System.out.println("=== NAVIGATION REQUESTS ===");
        system.addNavigationRequest(new NavigationRequest(101, dallas, plano));
        system.addNavigationRequest(new NavigationRequest(102, plano, royseCity));
        system.processNextRequest();
        system.processNextRequest();
        system.processNextRequest();

        System.out.println();
        System.out.println("=== CLEAR HISTORY ===");
        system.clearHistory();
        system.showHistory();
        system.goBack();
    }
}

