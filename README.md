This project implements a navigation system using custom data structures.
I did not use ArrayList or LinkedList from the Java Collection Framework.

Files:
NavigationArrayList.java - custom dynamic array
NavigationLinkedList.java - custom doubly linked list
NavigationIterator.java - custom iterator
NavigationStack.java - stack using NavigationLinkedList
NavigationQueue.java - circular-array queue
Location.java - location information
NavigationRequest.java - navigation request
NavigationSystem.java - navigation functionality
Main.java - driver/testing program

Implementation choices:
The array list starts small and doubles its capacity when full.
The linked list has head and tail references. The stack uses the end
of the linked list. The queue uses front/rear indexes and modulo arithmetic.

The navigation system uses linear search to find locations. Iterators are
used to display the custom lists.

Test cases:
- Add and display locations
- Find a location
- Visit locations
- Go back using LIFO
- Display travel history
- Add and process requests using FIFO
- Empty queue behavior
- Clear travel history

Complexity:
ArrayList: add-end O(1) amortized, add-index O(n), get O(1),
set O(1), remove O(n), find O(n).
LinkedList: addFirst O(1), addLast O(1), get O(n), set O(n),
remove O(n), clear O(1).
Stack: push O(1), pop O(1), peek O(1), isEmpty O(1), size O(1).
Queue: enqueue O(1) amortized, dequeue O(1), peek O(1).
NavigationSystem: addLocation O(1) amortized, findLocation O(n),
visitLocation O(n), goBack O(1), addNavigationRequest O(1) amortized,
processNextRequest O(1), showLocations O(n), showHistory O(n),
clearHistory O(1).

Compile:
javac *.java

Run:
java Main
