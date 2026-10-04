public class NavigationRequest {
    private int requestId;
    private Location start;
    private Location destination;

    public NavigationRequest(int requestId, Location start, Location destination) {
        this.requestId = requestId;
        this.start = start;
        this.destination = destination;
    }

    public int getRequestId() { return requestId; }
    public Location getStart() { return start; }
    public Location getDestination() { return destination; }

    public String toString() {
        return "Request " + requestId + ": " + start.getName()
                + " -> " + destination.getName();
    }
}

