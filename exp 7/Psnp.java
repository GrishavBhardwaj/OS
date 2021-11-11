package os;

import java.util.Scanner;

public class Psnp {

	int burstTime[];
	int priority[];
	int arrivalTime[];
	String processId[];
	int n;

	void getAll(Scanner sc) {
		
		System.out.print("Enter the number of Process for Scheduling           : ");
		int inputNumberOfProcess = sc.nextInt();
		
		n = inputNumberOfProcess;
		burstTime = new int[n];
		priority = new int[n];
		arrivalTime = new int[n];
		processId = new String[n];
		String st = "P";
		
		for (int i = 0; i < n; i++) {
			processId[i] = st.concat(Integer.toString(i));
			System.out.print("Enter the burst time   for Process - " + (i) + " : ");
			burstTime[i] = sc.nextInt();
			System.out.print("Enter the arrival time for Process - " + (i) + " : ");
			arrivalTime[i] = sc.nextInt();
			System.out.print("Enter the priority     for Process - " + (i) + " : ");
			priority[i] = sc.nextInt();
		}
	}

	void sorting(int[] at, int[] bt, int[] prt, String[] pid) {

		int temp;
		String stemp;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (at[j] > at[j + 1]) {
					// swapping accordingly
					temp = at[j];
					at[j] = at[j + 1];
					at[j + 1] = temp;

					temp = bt[j];
					bt[j] = bt[j + 1];
					bt[j + 1] = temp;

					temp = prt[j];
					prt[j] = prt[j + 1];
					prt[j + 1] = temp;

					stemp = pid[j];
					pid[j] = pid[j + 1];
					pid[j + 1] = stemp;

				}

				if (at[j] == at[j + 1]) {
					if (prt[j] > prt[j + 1]) {
						// swapping accordingly
						temp = at[j];
						at[j] = at[j + 1];
						at[j + 1] = temp;

						temp = bt[j];
						bt[j] = bt[j + 1];
						bt[j + 1] = temp;

						temp = prt[j];
						prt[j] = prt[j + 1];
						prt[j + 1] = temp;

						stemp = pid[j];
						pid[j] = pid[j + 1];
						pid[j + 1] = stemp;

					}
				}
			}

		}
	}

	void psnp() {
		int finishTime[] = new int[n];
		int bt[] = burstTime.clone();
		int at[] = arrivalTime.clone();
		int prt[] = priority.clone();
		String pid[] = processId.clone();
		int waitingTime[] = new int[n];
		int turnAroundTime[] = new int[n];

		sorting(at, bt, prt, pid);

		finishTime[0] = at[0] + bt[0];
		turnAroundTime[0] = finishTime[0] - at[0];
		waitingTime[0] = turnAroundTime[0] - bt[0];

		for (int i = 1; i < n; i++) {
			finishTime[i] = bt[i] + finishTime[i - 1];
			turnAroundTime[i] = finishTime[i] - at[i];
			waitingTime[i] = turnAroundTime[i] - bt[i];
		}
		
		float sum = 0;
		for (int n : waitingTime) {
			sum += n;
		}
		float averageWaitingTime = sum / n;

		sum = 0;
		for (int n : turnAroundTime) {
			sum += n;
		}
		float averageTurnAroundTime = sum / n;


		System.out.println("Priority Scheduling Algorithm : ");
		System.out.format("%20s%20s%20s%20s%20s%20s%20s\n", "ProcessId", "BurstTime", "ArrivalTime", "Priority",
				"FinishTime", "WaitingTime", "TurnAroundTime");
		for (int i = 0; i < n; i++) {
			System.out.format("%20s%20d%20d%20d%20d%20d%20d\n", pid[i], bt[i], at[i], prt[i], finishTime[i],
					waitingTime[i], turnAroundTime[i]);
		}

		System.out.format("%100s%20f%20f\n", "Average", averageWaitingTime, averageTurnAroundTime);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Psnp obj = new Psnp();
		obj.getAll(sc);
		obj.psnp();
	}
}
