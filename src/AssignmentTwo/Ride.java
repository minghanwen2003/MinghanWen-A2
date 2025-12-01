package AssignmentTwo;

import java.io.*;
import java.util.*;

public class Ride implements RideInterface {
    private String rideName;
    private boolean isOpen;
    private Employee operator;
    private int maxRiders;
    private Queue<Visitor> visitorQueue;
    private LinkedList<Visitor> rideHistory;
    private int numOfCycles;

    public Ride() {}
    public Ride(String rideName, boolean isOpen, Employee operator, int maxRiders) {
        this.rideName = rideName;
        this.isOpen = isOpen;
        this.operator = operator;
        this.maxRiders = maxRiders;
        this.visitorQueue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
        this.numOfCycles = 0;
    }

    @Override
    public void addVisitorToQueue(Visitor visitor) {
        if (visitor == null) {
            System.out.println("Visitor is null, cannot add to queue.");
            return;
        }
        visitorQueue.add(visitor);
        System.out.println("Visitor " + visitor.getName() + " added to queue.");
    }

    @Override
    public void removeVisitorFromQueue(Visitor visitor) {
        if (visitorQueue.remove(visitor)) {
            System.out.println("Visitor " + visitor.getName() + " removed from queue.");
        } else {
            System.out.println("Visitor " + visitor.getName() + " not found in queue.");
        }
    }

    @Override
    public void printQueue() {
        if (visitorQueue.isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.println("Queue contents:");
        for (Visitor v : visitorQueue) {
            System.out.println(v.getName() + " (" + v.getTicketNumber() + ")");
        }
    }

    @Override
    public void runOneCycle() {
        if (operator == null) {
            System.out.println("No operator, cannot run ride.");
            return;
        }
        if (visitorQueue.isEmpty()) {
            System.out.println("Queue empty, cannot run ride.");
            return;
        }
        int riders = Math.min(maxRiders, visitorQueue.size());
        for (int i = 0; i < riders; i++) {
            Visitor v = visitorQueue.poll();
            rideHistory.add(v);
            System.out.println(v.getName() + " is riding " + rideName + ".");
        }
        numOfCycles++;
        System.out.println("Ride completed. Total cycles: " + numOfCycles);
    }

    @Override
    public void addVisitorToHistory(Visitor visitor) {
        if (visitor == null) {
            System.out.println("Visitor is null, cannot add to history.");
            return;
        }
        rideHistory.add(visitor);
        System.out.println("Visitor " + visitor.getName() + " added to history.");
    }

    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        return rideHistory.contains(visitor);
    }

    @Override
    public int numberOfVisitors() {
        return rideHistory.size();
    }
@Override
public void printRideHistory() {
    if (rideHistory.isEmpty()) {
        System.out.println("History is empty.");
        return;
    }
    System.out.println("Ride history:");
    Iterator<Visitor> it = rideHistory.iterator();
    while (it.hasNext()) {
        Visitor v = it.next();
        System.out.println(v.getName() + " (" + v.getTicketNumber() + ")");
    }
}
    @Override
    public void sortRideHistory() {
        rideHistory.sort(new VisitorComparator());
        System.out.println("History sorted by name+ticket.");
    }

    public void exportRideHistory(String filename) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (Visitor v : rideHistory) {
                bw.write(v.getName() + " (" + v.getTicketNumber() + ")");
                bw.newLine();
            }
            System.out.println("Exported to " + filename);
        } catch (IOException e) {
            System.out.println("Export error: " + e.getMessage());
        }
    }

    public void importRideHistory(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains(" (") && line.endsWith(")")) {
                    int idx = line.indexOf(" (");
                    String name = line.substring(0, idx);
                    String ticket = line.substring(idx + 2, line.length() - 1);
                    Visitor v = new Visitor(name, 0, "Unknown", ticket, "Unknown");
                    rideHistory.add(v);
                }
            }
            System.out.println("Imported from " + filename);
        } catch (IOException e) {
            System.out.println("Import error: " + e.getMessage());
        }
    }

    public String getRideName() { return rideName; }
    public void setRideName(String rideName) { this.rideName = rideName; }
    public boolean isOpen() { return isOpen; }
    public void setOpen(boolean open) { isOpen = open; }
    public Employee getOperator() { return operator; }
    public void setOperator(Employee operator) { this.operator = operator; }
    public int getMaxRiders() { return maxRiders; }
    public void setMaxRiders(int maxRiders) { this.maxRiders = maxRiders; }
    public int getNumOfCycles() { return numOfCycles; }
}