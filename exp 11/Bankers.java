package os;

import java.util.*;

public class Bankers {
	void isSafe(int tp, int tr, int[] safeSequence, int[] avail, int[][] alloc, int[][] need) {
		int count = 0;

		boolean visited[] = new boolean[tp];
		for (int i = 0; i < tp; i++) {
			visited[i] = false;
		}

		int temp[] = new int[tr];
		for (int i = 0; i < tr; i++) {
			temp[i] = avail[i];
		}

		while (count < tp) {
			boolean flag = false;
			for (int i = 0; i < tp; i++) {
				if (visited[i] == false) {
					int j;
					for (j = 0; j < tr; j++) {
						if (need[i][j] > temp[j])
							break;
					}
					if (j == tr) {
						safeSequence[count++] = i;
						visited[i] = true;
						flag = true;

						for (j = 0; j < tr; j++) {
							temp[j] = temp[j] + alloc[i][j];
						}
					}
				}
			}
			if (flag == false) {
				break;
			}
		}

		if (count < tp) {
			System.out.println("UnSafe");
		}

		else {
			System.out.println("\nFollowing is the SAFE Sequence");
			for (int i = 0; i < tp; i++) {
				System.out.print("P" + safeSequence[i]);
				if (i != tp - 1)
					System.out.print(" -> ");
			}
		}
	}

	void calculateNeed(int tp, int tr, int[][] need, int[][] max, int[][] alloc) {
		for (int i = 0; i < tp; i++) {
			for (int j = 0; j < tr; j++) {
				need[i][j] = max[i][j] - alloc[i][j];
			}
		}

		System.out.println(
				"\nNeed :\n" + Arrays.deepToString(need).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));
	}

	public static void main(String[] args) {
		Bankers bnk = new Bankers();
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter no of processes : ");
		int tp = sc.nextInt();
		int tr = 3;
		int need[][] = new int[tp][tr];
		int[][] max = new int[tp][tr];
		int[][] alloc = new int[tp][tr];
		int[] available = new int[tr];
		int safeSequence[] = new int[tp];

		System.out.println("\nEnter ALLOCATION Matrix :");
		for (int i = 0; i < tp; i++) {
			System.out.println();
			for (int j = 0; j < tr; j++) {
				System.out.print("Enter alloc for [" + (i) + "][" + (j) + "] ->");
				alloc[i][j] = sc.nextInt();
			}
		}

		System.out.println("\nEnter MAX Matrix :");
		for (int i = 0; i < tp; i++) {
			System.out.println();
			for (int j = 0; j < tr; j++) {
				System.out.print("Enter max for [" + (i) + "][" + (j) + "] ->");
				max[i][j] = sc.nextInt();
			}
		}

		System.out.println("\nEnter AVAILABLE Resources :");
		for (int i = 0; i < tr; i++) {
			available[i] = sc.nextInt();
		}

		System.out.println("\nAllocation :\n"
				+ Arrays.deepToString(alloc).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));
		System.out.println(
				"\nMax :\n" + Arrays.deepToString(max).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));

		bnk.calculateNeed(tp, tr, need, max, alloc);
		bnk.isSafe(tp, tr, safeSequence, available, alloc, need);
		sc.close();
	}

}