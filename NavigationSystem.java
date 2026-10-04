public class NavigationSystem {
    private NavigationArrayList<Location> locations = new NavigationArrayList<Location>();
    private NavigationLinkedList<Location> history = new NavigationLinkedList<Location>();
    private NavigationStack<Location> backStack = new NavigationStack<Location>();
    private NavigationQueue<NavigationRequest> requests = new NavigationQueue<NavigationRequest>();
    private Location currentLocation;

    public void addLocation(Location location) {
        locations.add(location);
        System.out.println("Location added: " + location.getName());
    }

    public Location findLocation(int locationID) {
        for (Location location : locations)
            if (location.getId() == locationID) return location;
        return null;
    }

    public void visitLocation(int locationID) {
        Location location = findLocation(locationID);
        if (location == null) {
            System.out.println("Location not found.");
            return;
        }
        if (currentLocation != null) backStack.push(currentLocation);
        currentLocation = location;
        history.addLast(location);
        System.out.println("Now at " + location.getName());
    }

    public void goBack() {
        if (backStack.isEmpty()) {
            System.out.println("No previous location available.");
            return;
        }
        currentLocation = backStack.pop();
        System.out.println("Now at " + currentLocation.getName());
    }

    public void addNavigationRequest(NavigationRequest request) {
        requests.enqueue(request);
        System.out.println("Navigation request added.");
    }

    public void processNextRequest() {
        if (requests.isEmpty()) {
            System.out.println("No navigation requests available.");
            return;
        }
        NavigationRequest request = requests.dequeue();
        System.out.println("Processing request " + request.getRequestId());
    }

    public void showHistory() {
        if (history.isEmpty()) {
            System.out.println("No travel history available.");
            return;
        }
        System.out.println("Travel History:");
        for (Location location : history) System.out.println(location);
    }

    public void showLocations() {
        if (locations.isEmpty()) {
            System.out.println("No locations available.");
            return;
        }
        System.out.println("All Locations:");
        for (Location location : locations) System.out.println(location);
    }

    public void clearHistory() {
        history.clear();
        backStack.clear();
        System.out.println("Travel history cleared.");
    }
}

