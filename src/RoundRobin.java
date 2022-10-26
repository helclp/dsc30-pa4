/*
 * NAME: Patrick Helcl
 * PID: A16340930
 */

/**
 * Contains the methods and attributes that make the RoundRobin class sch
 *
 * @author Patrick Helcl
 * @since 10/24/22
 */
public class RoundRobin {

    /* constants */
    private static final String TASK_HANDLED = "All tasks are already handled.";
    static final int quantumDefault = 4;

    /* instance variables */
    private DoublyLinkedList<Task> waitlist, finished;
    private int quantum, burstTime, waitTime;

    /**
     * Constructor for RoundRobin with only array of Tasks, quantum set to default of 4.
     * @param toHandle an array of tasks used to with other method
     */
    public RoundRobin(Task[] toHandle) {

        this(quantumDefault, toHandle);
    }

    /**
     * Constructor for roundRobin that takes a desired quantum and array of Tasks
     * @param quantum an integer
     * @param toHandle
     */
    public RoundRobin(int quantum, Task[] toHandle) {
        if (quantum < 1) throw new IllegalArgumentException();
        if (toHandle == null || toHandle.length ==0) throw new IllegalArgumentException();
        this.quantum = quantum;
        burstTime = 0;
        waitTime= 0;
        waitlist = new DoublyLinkedList<>();
        finished = new DoublyLinkedList<>();

        for (int i =0; i < toHandle.length; i++){
            waitlist.add(toHandle[i]);
        }
    }

    /**
     * method that goes through tasks in the waitlist and utilizes handle task on each task object
     * results in the finished DLL being sorted in order of task completion
     * @return a string representation of that summarizes the result of handle task after
     * completion
     */
    public String handleAllTasks() {
        if (waitlist.size() == 0) return TASK_HANDLED;

        Task currentTask;

        while (waitlist.size() > 0){

            currentTask = waitlist.get(0);

            for(int i =0; i < quantum; i++){
                currentTask.handleTask();
                burstTime +=1;
                waitTime += waitlist.size()-1;

                if(currentTask.isFinished()){
                    finished.add(currentTask);
                    waitlist.remove(0);
                    break;
                }
            }

            if(!currentTask.isFinished()){
                waitlist.remove(0);
                waitlist.add(currentTask);
            }

        }

        String finishedString = "";
        Task taskHolder;
        for(int k = 0; k < finished.size(); k++){
            taskHolder = finished.get(k);
            finishedString += taskHolder.toString();
            if(k != finished.size()-1){
                finishedString += " -> ";
            }
        }
        String burstString = String.valueOf(burstTime);
        String waitString = String.valueOf(waitTime);

        return "All tasks are handled within " + burstString + " units of burst time and " +
                waitString + " units of wait time. The tasks are finished in this order: \n"+
                finishedString;
    }

    /**
     * Main method for testing.
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Task[] test1 = {new Task("A", 3), new Task("B", 4),
                new Task("C", 4), new Task("D", 12),
                new Task("E", 6), new Task("F", 3)};
        RoundRobin rr1 = new RoundRobin(3, test1);     // Quantum: 3, ToHandle: test1
        System.out.println(rr1.handleAllTasks());   // Burst: 32, Wait: 86, Order: AFBCED
        System.out.println();
        System.out.println(rr1.handleAllTasks());   // TASK_HANDLED
        System.out.println();

        Task[] test2 = {new Task("A", 9), new Task("B", 8),
                new Task("C", 6), new Task("D", 4),
                new Task("E", 4), new Task("F", 3)};
        RoundRobin rr2 = new RoundRobin(test2);  // Quantum: 4, ToHandle: test2
        System.out.println(rr2.handleAllTasks());   // Burst: 34, Wait: 123, Order: DEFBCA
        System.out.println();
        System.out.println(rr2.handleAllTasks());   // TASK_HANDLED
        System.out.println();

        Task[] test3 = {new Task("A", 7), new Task("B", 5),
                new Task("C", 3), new Task("D", 1),
                new Task("E", 2), new Task("F", 4),
                new Task("G", 6), new Task("H", 8)};
        RoundRobin rr3 = new RoundRobin(3, test3);     // Quantum: 3, ToHandle: test3
        System.out.println(rr3.handleAllTasks());   // Burst: 36, Wait: 148, Order: CDEBFGAH
        System.out.println();
        System.out.println(rr3.handleAllTasks());   // TASK_HANDLED
        System.out.println();
    }
}

