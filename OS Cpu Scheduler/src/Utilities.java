import java.util.*;

// Source code
public class Utilities {

    ArrayList<Process> listOfProcesses;
    int contextSwitch;
    int timer;
    public Utilities(ArrayList<Process> listOfProcesses, int contextSwitch, int timer) {
        this.listOfProcesses = listOfProcesses;
        this.contextSwitch = contextSwitch;
        this.timer = timer;
    }

    public void calUtilities()
    {
        double sumTurnAroundTime = 0.0;
        double avgTurnAroundTime = 0.0;
        double sumWaitingTime = 0.0;
        double avgWaitingTime = 0.0;
        double sumUtil = 0.0;
        double cpuUtilization = 0.0;

        for(int i = 0; i < listOfProcesses.size(); i++) {
            sumTurnAroundTime += listOfProcesses.get(i).completionTime - listOfProcesses.get(i).arrivalTime;
            sumWaitingTime += (listOfProcesses.get(i).completionTime - listOfProcesses.get(i).arrivalTime) - listOfProcesses.get(i).burstTime;
            sumUtil += listOfProcesses.get(i).burstTime;
        }

        cpuUtilization = sumUtil / (contextSwitch + sumTurnAroundTime);


        double throughput = (double)listOfProcesses.size() / timer;

        avgWaitingTime = sumWaitingTime / listOfProcesses.size();

        avgTurnAroundTime = sumTurnAroundTime / listOfProcesses.size();
        /********************************************************************
         *   Calculate the statistic data
         *	1. CPU Utilization = (burst time - (contextTime * 0.1)) / processes
         *	2. Throughput = processes / timer
         *	3. Average Waiting Time = sum of all wait / processes
         *	4. Average Turnaround Time = sum of all turn / processes
         *
         *
         *********************************************************************/

        System.out.println("");
        System.out.println("CPU Utilization: " + cpuUtilization);
        System.out.println("Throughput: " + throughput);
        System.out.println("Average Waiting Time: " + avgWaitingTime);
        System.out.println("Average Turnaround Time: " + avgTurnAroundTime);
    }
}