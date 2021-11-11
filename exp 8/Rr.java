package os;

import java.util.Scanner;

public class Rr {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		int i, n, sum = 0, count = 0, y, quant, wt = 0, tat = 0;
		float avg_wt, avg_tat;
		System.out.print(" Total number of process in the system: ");
		n = sc.nextInt();
		int at[] = new int[n];
		int bt[] = new int[n];
		int temp[] = new int[n];
		y = n;

		for (i = 0; i < n; i++) {
			System.out.print("Enter the Arrival and Burst time of the Process[" + (i + 1) + "]");
			System.out.print(" Arrival time is: \t");
			at[i] = sc.nextInt();
			System.out.print(" \nBurst time is: \t");
			bt[i] = sc.nextInt();
			temp[i] = bt[i];
		}

		System.out.print("Enter the Time Quantum for the process: \t");
		quant = sc.nextInt();

		System.out.println(
				"\nProcess No \t\t Arrival Time \t\t Burst Time \t\t Completion Time \t\t TAT \t\t Waiting Time");

		for (sum = 0, i = 0; y != 0;) {
			if (temp[i] <= quant && temp[i] > 0) {
				sum = sum + temp[i];
				temp[i] = 0;
				count = 1;
			} else if (temp[i] > 0) {
				temp[i] = temp[i] - quant;
				sum = sum + quant;
			}
			if (temp[i] == 0 && count == 1) {
				y--;
				System.out.format("Process No[%d] \t\t %d \t\t\t %d\t\t\t %d \t\t\t\t %d\t\t %d \n", i + 1, at[i],
						bt[i], sum, sum - at[i], sum - at[i] - bt[i]);
				wt = wt + sum - at[i] - bt[i];
				tat = tat + sum - at[i];
				count = 0;
			}
			if (i == n - 1) {
				i = 0;
			} else if (at[i + 1] <= sum) {
				i++;
			} else {
				i = 0;
			}
		}

		avg_wt = (float) (wt / n);
		avg_tat = (float) (tat / n);
		System.out.format("\n Average Turn Around Time: \t%f", avg_tat);
		System.out.format("\n Average Waiting Time: \t\t%f", avg_wt);
	}

}
