package athrav;

import java.util.Scanner;

public class Round {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the number of processes: ");
        int Pno = sc.nextInt();
        
        int process[] = new int[Pno];
        int Burst_time[] = new int[Pno];
        int Arrival_time[] = new int[Pno];
        int Remaining_time[] = new int[Pno];
        int WT[] = new int[Pno];
        int TAT[] = new int[Pno];
        int Completion_time[] = new int[Pno];
        
        // Input burst times
        System.out.println("Enter Burst Time for each process: ");
        for(int i = 0; i < Pno; i++) {
            System.out.print("Process " + (i+1) + " Burst Time: ");
            Burst_time[i] = sc.nextInt();
            Remaining_time[i] = Burst_time[i];
            process[i] = i + 1;
        }
        
        // Input arrival times (assuming all arrive at time 0 for simplicity)
        System.out.println("Enter Arrival Time for each process (0 for all if same arrival): ");
        for(int i = 0; i < Pno; i++) {
            System.out.print("Process " + (i+1) + " Arrival Time: ");
            Arrival_time[i] = sc.nextInt();
        }
        
        System.out.println("Enter Time Quantum: ");
        int TimeQuantum = sc.nextInt();
        
        // Round Robin Scheduling Algorithm
        int currentTime = 0;
        boolean completed;
        
        do {
            completed = true;
            
            for(int i = 0; i < Pno; i++) {
                if(Remaining_time[i] > 0 && Arrival_time[i] <= currentTime) {
                    completed = false;
                    
                    if(Remaining_time[i] > TimeQuantum) {
                        currentTime += TimeQuantum;
                        Remaining_time[i] -= TimeQuantum;
                    } else {
                        currentTime += Remaining_time[i];
                        Completion_time[i] = currentTime;
                        Remaining_time[i] = 0;
                    }
                }
            }
        } while(!completed);
        
        // Calculate waiting time and turnaround time
        float avg_wt = 0, avg_tat = 0;
        for(int i = 0; i < Pno; i++) {
            TAT[i] = Completion_time[i] - Arrival_time[i];
            WT[i] = TAT[i] - Burst_time[i];
            avg_wt += WT[i];
            avg_tat += TAT[i];
        }
        
        avg_wt /= Pno;
        avg_tat /= Pno;
        
        // Display results
        System.out.println("\nProcess\tBT\tAT\tCT\tWT\tTAT");
        for(int i = 0; i < Pno; i++) {
            System.out.println("P" + process[i] + "\t" + Burst_time[i] + "\t" + 
                             Arrival_time[i] + "\t" + Completion_time[i] + "\t" + 
                             WT[i] + "\t" + TAT[i]);
        }
        
        System.out.printf("\nAverage Waiting Time: %.2f", avg_wt);
        System.out.printf("\nAverage Turnaround Time: %.2f", avg_tat);
    }
}
