package Scheduling;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Prority {
	
		static class Process {
			int id;
			int burstTime;
			int arrivalTime;
			int priority;
			int remainingTime;
			int waitingTime;
			int turnaroundTime;
			int completionTime;
			
//			CONSTRUCTORS:
			public Process (int id, int burstTime, int arrivalTime) {
				this.id = id;
				this.burstTime = burstTime;
				this.arrivalTime = arrivalTime;
				this.remainingTime = burstTime;
			}
			
			public Process (int id, int burstTime, int priority, boolean isPrority) {
				this.id = id;
				this.burstTime = burstTime;
				this.priority = priority;
				this.arrivalTime = 0;
				this.remainingTime = burstTime;
				
			}
			
			public Process (int id, int burstTime) {
				this.id = id;
				this.burstTime = burstTime;
				
			}
		}
		
//		PRINT_RESULTS:
		public static void printResults(List<Process> processes, boolean showArrival, boolean showPriority) {
		    double totalWaitingTime = 0;
		    double totalTurnaroundTime = 0;

		    processes.sort(Comparator.comparing(p -> p.id));

		    System.out.println("\n-------------------------------------------------------");
		    System.out.printf("%-10s%-15s", "Process", "Burst Time");
		    if (showArrival) System.out.printf("%-15s", "Arrival Time");
		    if (showPriority) System.out.printf("%-15s", "Priority");
		    System.out.printf("%-15s%-15s\n", "Waiting Time", "Turnaround Time");
		    System.out.println("-------------------------------------------------------");

		    for (Process p : processes) {
		        totalWaitingTime += p.waitingTime;
		        totalTurnaroundTime += p.turnaroundTime;

		        System.out.printf("%-10s%-15d", "P" + p.id, p.burstTime);
		        if (showArrival) System.out.printf("%-15d", p.arrivalTime);
		        if (showPriority) System.out.printf("%-15d", p.priority);
		        System.out.printf("%-15d%-15d\n", p.waitingTime, p.turnaroundTime);
		    }

		    System.out.println("-------------------------------------------------------");
		    System.out.printf("Average Waiting Time: %.2f\n", totalWaitingTime / processes.size());
		    System.out.printf("Average Turnaround Time: %.2f\n", totalTurnaroundTime / processes.size());
		}
		
		public static void runPriority(Scanner sc) {
			System.out.print("Enter the number of Processes : ");
			int n = sc.nextInt();
			
			List<Process> processes = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				System.out.print("Enter Burst Time for Process" + (i + 1) + " : ");
				int bt = sc.nextInt();
				System.out.print("Enter Priority for Process" + (i+1) + "(lower number = higher priority) : ");
				int priority = sc.nextInt();
				processes.add(new Process(i+1, bt, priority, true));
			}
			
			processes.sort(Comparator.comparingInt(p -> p.priority));
			
			int currentTime = 0;
			
			for (Process p : processes) {
				p.waitingTime = currentTime;
				currentTime += p.burstTime;
				p.turnaroundTime = currentTime;				
			}
			
			printResults(processes, false, true);
			
		}
		
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			
			runPriority(sc);
			
		}

}
