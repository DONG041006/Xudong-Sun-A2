import java.util.Comparator;

public class VisitorComparator implements Comparator<Visitor> {
    @Override
    public int compare(Visitor v1, Visitor v2) {
        // 1. Sort by VIP status first: VIP (true) first, non VIP (false) last
        int vipCompare = Boolean.compare(v2.isVip(), v1.isVip());
        if (vipCompare != 0) {
            return vipCompare;
        }
        // 2.Sort by age in ascending order if VIP status is the same
        return Integer.compare(v1.getAge(), v2.getAge());
    }
}