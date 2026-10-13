import java.util.LinkedList;
import java.util.Queue;
import java.util.Map;
import java.util.HashMap;
import java.util.Random;

// ANSI Color Codes for enhanced terminal output
class Colors {
    public static final String RESET = "\u001B[0m";
    public static final String BOLD = "\u001B[1m";
    public static final String CYAN = "\u001B[36m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String MAGENTA = "\u001B[35m";
    public static final String BLUE = "\u001B[34m";
    public static final String RED = "\u001B[31m";
    public static final String BG_BLUE = "\u001B[44m";
    public static final String BG_GREEN = "\u001B[42m";
}

class SimProcess {
    String name;
    int burstTime;
    int remainingTime;
    int arrivalTime;
    int completionTime;
    int turnaroundTime;
    int waitingTime;
    int priority; // Feature 1: Priority

    public SimProcess(String name, int burstTime, int arrivalTime, Random random) {
        this.name = name;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.arrivalTime = arrivalTime;
        this.priority = random.nextInt(10) + 1; // Feature 1: Priority 1-10
    }
}

public class SchedulerSimulation {
    public static int contextSwitchCount = 0; // Feature 2: Static Context Switch Counter

    public static void main(String[] args) {
        int studentId = 444052409; // Student ID
        Random random = new Random(studentId);

        int timeQuantum = 2;
        int currentTime = 0;

        Queue<SimProcess> readyQueue = new LinkedList<>();
        LinkedList<SimProcess> allProcesses = new LinkedList<>();

        int numProcesses = 5;
        for (int i = 1; i <= numProcesses; i++) {
            int burstTime = random.nextInt(8) + 2;
            SimProcess p = new SimProcess("P" + i, burstTime, 0, random);
            allProcesses.add(p);
            readyQueue.add(p);
            System.out.println(Colors.CYAN + "[QUEUE] " + p.name + " entered Ready Queue (Burst: " + p.burstTime + "s, Priority: " + p.priority + ")" + Colors.RESET);
        }

        System.out.println("\n" + Colors.BOLD + Colors.BG_BLUE + "--- CPU Scheduling Simulation Started (Round Robin Q=" + timeQuantum + ") ---" + Colors.RESET + "\n");

        while (!readyQueue.isEmpty()) {
            SimProcess current = readyQueue.poll();
            contextSwitchCount++; // Feature 2: Increment Counter

            int executeTime = Math.min(current.remainingTime, timeQuantum);
            System.out.println(Colors.YELLOW + "[CPU] Executing " + current.name + " for " + executeTime + "s (Remaining: " + (current.remainingTime - executeTime) + "s)" + Colors.RESET);

            currentTime += executeTime;
            current.remainingTime -= executeTime;

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (current.remainingTime > 0) {
                readyQueue.add(current);
                System.out.println(Colors.MAGENTA + "[CONTEXT SWITCH] " + current.name + " re-entered Ready Queue" + Colors.RESET);
            } else {
                current.completionTime = currentTime;
                current.turnaroundTime = current.completionTime - current.arrivalTime;
                current.waitingTime = current.turnaroundTime - current.burstTime; // Feature 3: Waiting Time
                System.out.println(Colors.GREEN + "[COMPLETED] " + current.name + " finished at time " + currentTime + "s" + Colors.RESET);
            }
        }

        // Feature 3: Summary Table
        System.out.println("\n" + Colors.BOLD + "=== Process Summary Table ===" + Colors.RESET);
        System.out.println("---------------------------------------------------------------");
        System.out.printf("%-15s | %-12s | %-12s | %-15s\n", "Process Name", "Burst Time", "Waiting Time", "Turnaround Time");
        System.out.println("---------------------------------------------------------------");
        for (SimProcess p : allProcesses) {
            System.out.printf("%-15s | %-12d | %-12d | %-15d\n", p.name, p.burstTime, p.waitingTime, p.turnaroundTime);
        }
        System.out.println("---------------------------------------------------------------");
        System.out.println(Colors.BOLD + "Total Context Switches: " + contextSwitchCount + Colors.RESET);
    }
}
