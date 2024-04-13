import java.util.Random;

class LinkQueueApp {
   public static void main(String[] args) {
      LinkQueue theQueue = new LinkQueue();
      theQueue.insert(20); // insert items
      theQueue.insert(40);
      theQueue.displayQueue();
      long removed = theQueue.delayedRemove(3); // display queue

      theQueue.insert(60); // insert items
      theQueue.insert(80);
      theQueue.displayQueue(); // display queue

      removed = theQueue.delayedRemove(3);
      removed = theQueue.delayedRemove(3);
      theQueue.displayQueue(); // display queue

      System.out.println("---------------------------------------");
      int avgTime = 5;
      int serviceTimeVn = 2;

      LinkQueue customerQueue = new LinkQueue();

      int simulationTime = 30; 
      int arrivalRate = 2; 

      Random random = new Random();

      for (int time = 0; time < simulationTime; time++) {
         if (random.nextInt(60 / arrivalRate) == 0) {
            int serviceTime = avgTime + random.nextInt(2 * serviceTimeVn + 1) - serviceTimeVn;
            customerQueue.insert(serviceTime);
         }

         if (!customerQueue.isEmpty()) {
            int customerServiceTime = (int) customerQueue.delayedRemove(1);
            if (customerServiceTime != -1) {
               System.out.println("Minute " + time + ": Customer served after " + customerServiceTime + " minutes.");
            }
         }
         System.out.println("Minute " + time + ": Queue size = " + customerQueue.size());
      }
   } // end main()
} // end class LinkQueueApp