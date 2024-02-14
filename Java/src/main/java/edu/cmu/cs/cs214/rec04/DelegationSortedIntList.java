package edu.cmu.cs.cs214.rec04;

/**
 * DelegationSortedIntList -- a variant of a SortedIntList that keeps
 * count of the number of attempted element insertions (not to be confused
 * with the current size, which goes down when an element is removed)
 * and exports an accessor (totalAdded) for this count.
 *
 * @author Nora Shoemaker
 *
 */

public class DelegationSortedIntList implements IntegerList {
    // Write your implementation below with API documentation
    private SortedIntList list;
    private int totalAdded;

    public DelegationSortedIntList() {
        list = new SortedIntList();
        totalAdded = 0;
    }

    @Override
    public boolean add(int value) {
        boolean success = list.add(value);
        if (success) totalAdded++;
        return success;
    }

    @Override
    public boolean addAll(IntegerList values) {
        int oldSize = list.size();
        boolean success = list.addAll(values);
        int newSize = list.size();
        totalAdded += newSize - oldSize;
        return success;
    }

    @Override
    public int get(int index) {
        return list.get(index);
    }

    @Override
    public boolean remove(int value) {
        return list.remove(value);
    }

    @Override
    public boolean removeAll(IntegerList values) {
        return list.removeAll(values);
    }

    @Override
    public int size() {
        return list.size();
    }

    public int getTotalAdded() {
        return totalAdded;
    }

}