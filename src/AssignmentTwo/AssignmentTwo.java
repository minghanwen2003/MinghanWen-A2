package AssignmentTwo;

public class AssignmentTwo {
    public static void main(String[] args) {
        partThree();
        partFourA();
        partFourB();
        partFive();
        partSix();
        partSeven();
    }

    // Part 3 – Queue Interface
    public static void partThree() {
        System.out.println("=== Part 3 – Queue Interface ===");
        Employee op = new Employee("Liam", 35, "5 Martin Place", "E789", "caretaker");
        Ride ride = new Ride("Roller Coaster", true, op, 3);

        Visitor v1 = new Visitor("Charlotte", 25, "57 Pitt St", "V456", "Annual");
        Visitor v2 = new Visitor("Jackson", 22, "33 Macquarie St", "V202", "General");
        Visitor v3 = new Visitor("Ava", 28, "12 Crown St", "V303", "VIP");
        Visitor v4 = new Visitor("Ethan", 40, "42 Acacia St", "V404", "One-day");
        Visitor v5 = new Visitor("Liam M", 18, "105 Ocean Blvd", "V505", "VIP");

        ride.addVisitorToQueue(v1);
        ride.addVisitorToQueue(v2);
        ride.addVisitorToQueue(v3);
        ride.addVisitorToQueue(v4);
        ride.addVisitorToQueue(v5);

        System.out.println("Queue after adds:");
        ride.printQueue();

        ride.removeVisitorFromQueue(v3);
        System.out.println("Queue after remove:");
        ride.printQueue();
    }

    // Part 4A – Ride history (LinkedList)
    public static void partFourA() {
        System.out.println("\n=== Part 4A – Ride history ===");
        Employee op = new Employee("Max", 30, "32 George St", "E123", "Driver");
        Ride ride = new Ride("Thunder", true, op, 4);

        Visitor[] vs = {
            new Visitor("Charlotte", 25, "57 Pitt St", "V456", "Annual"),
            new Visitor("Jackson", 22, "33 Macquarie St", "V202", "General"),
            new Visitor("Ava", 28, "12 Crown St", "V303", "VIP"),
            new Visitor("Ethan", 40, "42 Acacia St", "V404", "One-day"),
            new Visitor("Liam M", 18, "105 Ocean Blvd", "V505", "VIP")
        };
        for (Visitor v : vs) ride.addVisitorToHistory(v);

        System.out.println("History size: " + ride.numberOfVisitors());
        System.out.println("Contains V303? " + ride.checkVisitorFromHistory(vs[2]));
        ride.printRideHistory();
    }

    // Part 4B – Sorting the ride history
    public static void partFourB() {
        System.out.println("\n=== Part 4B – Sorting ===");
        Employee op = new Employee("Max", 30, "32 George St", "E123", "Driver");
        Ride ride = new Ride("Thunder", true, op, 4);

        Visitor[] vs = {
            new Visitor("Zoe", 25, "Z St", "V999", "Annual"),
            new Visitor("Alice", 22, "A St", "V111", "General"),
            new Visitor("Bob", 28, "B St", "V222", "VIP"),
            new Visitor("Zoe", 25, "Z St", "V888", "One-day"),
            new Visitor("Charlie", 18, "C St", "V333", "VIP")
        };
        for (Visitor v : vs) ride.addVisitorToHistory(v);

        System.out.println("Before sort:");
        ride.printRideHistory();
        ride.sortRideHistory();
        System.out.println("After sort:");
        ride.printRideHistory();
    }

    // Part 5 – Run a ride cycle
    public static void partFive() {
        System.out.println("\n=== Part 5 – Run a ride cycle ===");
        Employee op = new Employee("Liam", 35, "5 Martin Place", "E789", "caretaker");
        Ride ride = new Ride("Roller Coaster", true, op, 3);

        for (int i = 1; i <= 10; i++) {
            ride.addVisitorToQueue(new Visitor("Visitor" + i, 20 + i, "Addr" + i, "V" + (1000 + i), "Type" + i));
        }
        System.out.println("Queue before cycle:");
        ride.printQueue();

        ride.runOneCycle();

        System.out.println("Queue after cycle:");
        ride.printQueue();
        System.out.println("History after cycle:");
        ride.printRideHistory();
    }

    // Part 6 – Writing to a file
    public static void partSix() {
        System.out.println("\n=== Part 6 – Export ===");
        Employee op = new Employee("Max", 30, "32 George St", "E123", "Driver");
        Ride ride = new Ride("Thunder", true, op, 4);

        Visitor[] vs = {
            new Visitor("Charlotte", 25, "57 Pitt St", "V456", "Annual"),
            new Visitor("Jackson", 22, "33 Macquarie St", "V202", "General"),
            new Visitor("Ava", 28, "12 Crown St", "V303", "VIP"),
            new Visitor("Ethan", 40, "42 Acacia St", "V404", "One-day"),
            new Visitor("Liam M", 18, "105 Ocean Blvd", "V505", "VIP")
        };
        for (Visitor v : vs) ride.addVisitorToHistory(v);

        ride.exportRideHistory("ride_history.txt");
    }

    // Part 7 – Reading from a file
    public static void partSeven() {
        System.out.println("\n=== Part 7 – Import ===");
        Employee op = new Employee("Max", 30, "32 George St", "E123", "Driver");
        Ride ride = new Ride("Thunder", true, op, 4);

        ride.importRideHistory("ride_history.txt");
        System.out.println("Imported count: " + ride.numberOfVisitors());
        ride.printRideHistory();
    }
}