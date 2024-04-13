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

      // theQueue.remove(); // remove items
      // theQueue.remove();
      removed = theQueue.delayedRemove(3);
      removed = theQueue.delayedRemove(3);
      // removed = theQueue.delayedRemove(2);
      theQueue.displayQueue(); // display queue

      System.out.println("---------------------------------------");
      int avgServiceTime = 5; // minutes (adjust as needed)
      int serviceTimeVariation = 2; // minutes (adjust as needed)

      // Create a queue for customers
      LinkQueue customerQueue = new LinkQueue();

      // Simulation parameters (adjust as needed)
      int simulationTime = 30; // minutes
      int arrivalRate = 2; // customers per minute (adjust as needed)

      Random random = new Random();

      // Simulate customer arrivals and service
      for (int time = 0; time < simulationTime; time++) {
         // Check for customer arrival
         if (random.nextInt(60 / arrivalRate) == 0) {
            // Generate random service time with variation
            int serviceTime = avgServiceTime + random.nextInt(2 * serviceTimeVariation + 1) - serviceTimeVariation;
            customerQueue.insert(serviceTime);
         }

         // Process customer at the front of the queue (if any)
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