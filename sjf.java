package sjfpremptive;

import java.util.Scanner;

public class Sjfp {
    public static void main(String[] args) {
        int burst_time[],process[],waiting_time[],tat[],arr_time[],completion_time[],i,j,n,total=0,total_comp=0,pos,temp;
        float wait_avg, TAT_avg;

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of process: ");
        n=sc.nextInt();
        process = new int[n];
        burst_time=new int[n];
        waiting_time=new int[n];
        arr_time=new int[n];
        tat=new int[n];
        completion_time=new int[n];


        //burst time
        System.out.println("\nEnter the burst time: ");
        for(i=0;i<n;i++) {
            System.out.println("\nProcess[" + (i + 1) + "]:");
            burst_time[i] = sc.nextInt();
            process[i] = i + 1; //process number
        }
        //arrival time
        System.out.println("Enter the arrival time:");
        for(i=0;i<n;i++){
            System.out.println("\nProcess["+(i+1)+"]:");
            arr_time[i]=sc.nextInt();
            process[i]=i+1;
        }

        //sorting
        for(i=0;i<n;i++){
            pos=i;
            for(j=i+1;j<n;j++){
                if(burst_time[j]<burst_time[pos])
                    pos=j;
            }

            temp=burst_time[i];
            burst_time[i]=burst_time[pos];
            burst_time[pos]=temp;

            temp=process[i];
            process[i]=process[pos];
            process[pos]=temp;

            System.out.println("process"+process[i]);

        }

        //completion time
        for(i=1;i<n;i++){
            completion_time[i]=0;
            for(j=0;j<1;j++){
                completion_time[i]+=burst_time[j];
                total_comp+=completion_time[i];
            }

            //first process having 0 waiting time
            waiting_time[0]=0;
            //calculate waiting time
            for(i=1;i<n;i++){
                waiting_time[i]=0;
                for(j=0;j<n;j++){
                    waiting_time[i]+=burst_time[j];
                    total+=waiting_time[i];
                }

                //calculating average waiting time

                wait_avg=(float)total/n;
                total=0;

                System.out.println("\npro_number\tBurst Time\tCompletion Time\tWaiting Time\tTurnaround Time");
                for(i=0;i<n;i++){
                    tat[i]=burst_time[i]+waiting_time[i];
                    //calculating turnaround time
                    total+=tat[i];
                    System.out.println("\n"+process[i]+"\t\t"+burst_time[i]+"\t\t"+completion_time[i]+"\t\t"+waiting_time[i]+"\t\t"+tat[i]);
                }

                //calculation of average turn around time
                TAT_avg=(float)total/n;
                System.out.println("\n\nAWT:"+wait_avg);
                System.out.println("\nATAT:"+TAT_avg);
            }
        }
    }
}
