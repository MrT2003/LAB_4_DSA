class Link {
   public long dData; // data item
   public Link next; // next link in list
   // -------------------------------------------------------------

   public Link(long dd) // constructor
   {
      dData = dd;
   }

   // -------------------------------------------------------------
   public void displayLink() // display ourself
   {
      System.out.print(dData + " ");
   }

   public long getdData() {
      return dData;
   }
} // end class Link
////////////////////////////////////////////////////////////////

class LinkList {
   private Link first; // ref to first item on list
   // -------------------------------------------------------------

   public LinkList() // constructor
   {
      first = null;
   } // no items on list yet
   // -------------------------------------------------------------

   public boolean isEmpty() // true if list is empty
   {
      return (first == null);
   }

   // -------------------------------------------------------------
   public void insertFirst(long dd) // insert at start of list
   { // make new link
      Link newLink = new Link(dd);
      newLink.next = first; // newLink --> old first
      first = newLink; // first --> newLink
   }

   // -------------------------------------------------------------
   public long deleteFirst() // delete first item
   { // (assumes list not empty)
      Link temp = first; // save reference to link
      first = first.next; // delete it: first-->old next
      return temp.dData; // return deleted link
   }

   // -------------------------------------------------------------
   public void displayList() {
      Link current = first; // start at beginning of list
      while (current != null) // until end of list,
      {
         current.displayLink(); // print data
         current = current.next; // move to next link
      }
      System.out.println("");
   }

   public int getLong(){
      int counter=0;

      Link current = first; 
      while(current != null)      // until end of list,
      {
      current = current.next; 
      counter++; 
      }

      return counter; 

    }

   public long getFirst() {
      return first.getdData();
   }
   // -------------------------------------------------------------
} // end class LinkList
////////////////////////////////////////////////////////////////

class LinkStack {
   private LinkList theList;

   // --------------------------------------------------------------
   public LinkStack() // constructor
   {
      theList = new LinkList();
   }

   // --------------------------------------------------------------
   public void push(long j) // put item on top of stack
   {
      theList.insertFirst(j);
   }

   // --------------------------------------------------------------
   public long pop() // take item from top of stack
   {
      return theList.deleteFirst();
   }

   // --------------------------------------------------------------
   public boolean isEmpty() // true if stack is empty
   {
      return (theList.isEmpty());
   }

   // --------------------------------------------------------------
   public void displayStack() {
      System.out.print("Stack (top-->bottom): ");
      theList.displayList();
   }

   public void reverseList() // insert at start of list
   { // make new link
      LinkList newLink = new LinkList();
      // System.out.println(theList.getLong());
      for (int i = theList.getLong(); i != 0; i--) {
         newLink.insertFirst(theList.getFirst());
         theList.deleteFirst();

      }
      System.out.println("--------------------------------\nThe reversed list: ");
      newLink.displayList();

   }
   // --------------------------------------------------------------
} // end class LinkStack
////////////////////////////////////////////////////////////////

class LinkStackApp {
   public static void main(String[] args) {
      LinkStack theStack = new LinkStack(); // make stack

      theStack.push(20); // push items
      theStack.push(40);

      // theStack.displayStack(); // display stack

      theStack.push(60); // push items
      theStack.push(80);

      theStack.displayStack(); // display stack

      // theStack.pop(); // pop items
      // theStack.pop();

      // theStack.displayStack();              // display stack
      theStack.reverseList();
   } // end main()
} // end class LinkStackApp
////////////////////////////////////////////////////////////////