package os;

import java.util.Scanner;

public class Fifo {
	void findWaitingTime(int processes[], int n, int bt[], int wt[]) {
		wt[0] = 0;
		for (int i = 1; i < n; i++) {
			wt[i] = bt[i - 1] + wt[i - 1];
		}
	}

	void findTurnAroundTime(int processes[], int n, int bt[], int wt[], int tat[]) {
		for (int i = 0; i < n; i++) {
			tat[i] = bt[i] + wt[i];
		}
	}

	void findavgTime(int processes[], int n, int bt[]) {
		int wt[] = new int[n];
		int tat[] = new int[n];
		int total_wt = 0;
		int total_tat = 0;
		findWaitingTime(processes, n, bt, wt);
		findTurnAroundTime(processes, n, bt, wt, tat);
		System.out.print("Processes \t Burst time \t\t Waiting" + " time \t\t Turn around time\n");

		for (int i = 0; i < n; i++) {
			total_wt = total_wt + wt[i];
			total_tat = total_tat + tat[i];
			System.out.print(i + 1 + "\t\t\t");
			System.out.print(bt[i] + "\t\t\t");
			System.out.print(wt[i] + "\t\t\t");
			System.out.print(tat[i] + "\n");
		}
		float s = (float) total_wt / (float) n;
		int t = total_tat / n;
		System.out.print("Average waiting time = " + s + "\t");
		System.out.print("\n");
		System.out.print("Average turn around time = " + t + "\t");
	}

	public static void main(String[] args) {
		Scanner inp = new Scanner(System.in);
		System.out.println("Enter number of process");
		int n = inp.nextInt();
		System.out.println("Enter burst time");
		int burst_time[] = new int[n];
		int processes[] = new int[n];
		for (int i = 0; i < n; i++) {
			burst_time[i] = inp.nextInt();
		}
		for (int i = 0; i < n; i++) {
			processes[i] = i + 1;
		}
		Fifo obj = new Fifo();
		obj.findavgTime(processes, n, burst_time);
		inp.close();
	}
}