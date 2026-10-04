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


Testing

I tested the system with several different scenarios, including:

Adding and displaying locations

Finding a location

Visiting locations

Going back through travel history

Displaying travel history

Adding and processing navigation requests

Testing the queue when it is empty

Clearing travel history

Running the Project

Make sure you have Java installed, then compile all the files:

javac *.java

Run the program with:

java Main

What I Learned

This project helped me understand what is happening behind the scenes when using common data structures in Java.

Instead of relying on Java's built-in collections, I had to implement the logic myself. This gave me a better understanding of dynamic arrays, linked lists, stacks, queues, iterators, FIFO/LIFO behavior, and Big-O time complexity.

It also showed me how multiple data structures can work together to build a larger program rather than being used individually.


What I Built

The system can:

Add and find locations

Visit locations and keep track of travel history

Go back to previously visited locations

Add and process navigation requests

Display locations and travel history

Clear travel history

Handle an empty queue

Custom Data Structures

Instead of using Java's Collection Framework, I implemented my own versions of the main data structures:

NavigationArrayList – A dynamic array that automatically grows when it becomes full.

NavigationLinkedList – A doubly linked list with head and tail references.

NavigationIterator – Used to iterate through my custom lists.

NavigationStack – Uses the linked list to implement LIFO behavior (Last In, First Out).

NavigationQueue – Uses a circular array with front and rear indexes to implement FIFO behavior (First In, First Out).

Other classes handle the actual navigation functionality:

Location – Stores information about a location.

NavigationRequest – Represents a navigation request from one location to another.

NavigationSystem – Connects the data structures together and provides the navigation features.

Main – Runs the program and tests the different features.

How It Works

The NavigationSystem uses a linear search when looking for a location.

When a user visits a location, it is added to the travel history. The stack is then used when going back, since the most recently visited location should be the first one removed.

Navigation requests work differently. They use a queue, so the first request added is the first request processed.

The queue is implemented as a circular array, which allows the program to reuse empty spaces instead of constantly shifting elements.

Main Design Choices

A few important implementation decisions I made:

The dynamic array starts with a small capacity and doubles in size when it becomes full.

The linked list keeps both head and tail references so adding to either end is efficient.

The stack uses the end of the linked list for push and pop operations.

The queue uses front/rear indexes and modulo arithmetic to create a circular structure.

Iterators are used when displaying the custom lists.

Locations are found using a linear search.
