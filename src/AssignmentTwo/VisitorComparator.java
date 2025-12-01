package AssignmentTwo;

import java.util.Comparator;

public class VisitorComparator implements Comparator<Visitor> {
    @Override
    public int compare(Visitor v1, Visitor v2) {
        int nameCmp = v1.getName().compareTo(v2.getName());
        return (nameCmp != 0) ? nameCmp : v1.getTicketNumber().compareTo(v2.getTicketNumber());
    }
}