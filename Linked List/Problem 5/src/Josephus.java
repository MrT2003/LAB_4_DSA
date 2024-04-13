public class Josephus {

    private int numOfPeople; // number of people in a circle
    private int countNum; // number used for counting off
    private Node head;
    private Node tail;
    private int start; 
    CircularList circle;

    public Josephus() {
        circle = new CircularList();
        numOfPeople = 0;
        countNum = 0;

    }

    public void setNumOfPeople(int x) {
        numOfPeople = x;

    }

    public int getNumOfPeople() {
        return numOfPeople;
    }

    public void setCountNum(int x) {
        countNum = x;
    }

    public int getCountNum() {
        return countNum;
    }

    public void addPeople() {
        for (int i = 1; i <= numOfPeople; i++) {
            circle.insert(i);
        }
    }

    public void move() {

        for (int i = 1; i < countNum; i++) {
             
            tail = head;
            head = head.next;
        }
        System.out.println(head.iData + "  ");

    }


    public void execute() {
        tail = null;
        head = circle.getFirst();        
        for (int i =1; i< start; i++ ){ //move to start 
            tail = head;
            head = head.next;
        }

        while (numOfPeople != 1) {

            move();
            circle.delete(head.iData);
            tail = tail.next;
            head = head.next;
            numOfPeople--;
            // display();
        }

    }

    public void display() {
        circle.displayList();
    }

    public int getLastNum(){
        execute(); 
        display();
        return head.iData;
    }

    public void setStart(int start){
        this.start = start; 
    }

}