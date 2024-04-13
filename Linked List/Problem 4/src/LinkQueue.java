class LinkQueue {
    private FirstLastList theList;
    private int removeCount;

    // --------------------------------------------------------------
    public LinkQueue() // constructor
    {
        theList = new FirstLastList();
        removeCount = 0;
    }// make a 2-ended list
    // --------------------------------------------------------------

    public boolean isEmpty() // true if queue is empty
    {
        return theList.isEmpty();
    }

    // --------------------------------------------------------------
    public void insert(long j) // insert, rear of queue
    {
        theList.insertLast(j);
    }

    // --------------------------------------------------------------
    public long remove() // remove, front of queue
    {
        return theList.deleteFirst();
    }

    // --------------------------------------------------------------
    public void displayQueue() {
        System.out.print("Queue (front-->rear): ");
        theList.displayList();
    }

    public long delayedRemove(int n) {
        removeCount++; 
        if (removeCount == n) {
            removeCount = 0; // reset counter after removal
            return theList.deleteFirst();
        } else {
            return -1; // indicate no removal happened
        }
    }

    public int size() {
        return theList.size();
    }
    // --------------------------------------------------------------
} // end class LinkQueue