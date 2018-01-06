package Demo;

import java.util.Scanner;

public class Demo2 {
	static int flag = 0;

	static void dis(int a[][]) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
			for (int k = 0; k <= i; k++)
				System.out.print(" ");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			int a[][] = new int[5][5];

			Scanner sc = new Scanner(System.in);

			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					a[i][j] = 0;
					System.out.print(a[i][j] + " ");
				}
				System.out.println();
				for (int k = 0; k <= i; k++)
					System.out.print(" ");
			}

			int c = 0;
			while (c < 25) {

				System.out.println();

				int m = sc.nextInt();
				int n = sc.nextInt();
				if (c % 2 == 0 && a[m][n] != 1 && a[m][n] != 2) {
					a[m][n] = 1;
					Demo2.dis(a);

				}

				else if (c % 2 == 1 && a[m][n] != 1 && a[m][n] != 2) {
					a[m][n] = 2;
					Demo2.dis(a);
				}

				else {
					System.out.println("try other one...");
					c--;
				}

				if (c >= 8) {
					// for line search.....
					for (int j = 0; j < 5; j++) {
						if (a[0][j] == 1)
							rec(0, j, 3, a);
						//System.out.println("calling rec ");
					}

					;
				}
				c++;

			}
			sc.close();
		} catch (Exception e) {
			System.out.println(Thread.currentThread());
			e.printStackTrace();
			System.out.println("range is 0-4");
		}

	}

	static void rec(int i, int j, int m, int a[][]) {
		for (int k = 0; k < 6; k++) {
			if (k == (m + 3) % 6) {
				continue;
			} else {
				if (i == 4) {
					System.out.println("1 winner");
				} else {
					if (goingpath(i, j, k, a) == true) {
						rec(updatei(i, k), updatej(j, k), k, a);
					}
				}
			}
		}
	}

	static boolean goingpath(int i, int j, int k, int a[][]) {

		if (a[updatei(i, k)][updatej(j, k)] == 1 && flag == 1) {
			return true;
		} else {
			flag = 1;
			return false;
		}

	}

	static int updatei(int i, int k) {
		if (k == 0 && i - 1 >= 0) {
			return i - 1;
		} else if (k == 1 && i >= 0) {
			return i;
		} else if (k == 2 && i + 1 <= 4) {
			return i + 1;
		} else if (k == 3 && i + 1 <= 4) {
			return i + 1;
		} else if (k == 4) {
			return i;
		} else if (k == 5 && i - 1 >= 0) {
			return i - 1;
		} else {
			flag = 0;
			return 0;
		}

	}

	static int updatej(int j, int k) {
		if (k == 0 && j + 1 <= 4) {
			return j + 1;
		} else if (k == 1 && j + 1 <= 4) {
			return j + 1;
		} else if (k == 2) {
			return j;
		} else if (k == 3 && j - 1 >= 0) {
			return j - 1;
		} else if (k == 4 && j - 1 >= 0) {
			return j - 1;
		} else if (k == 5) {
			return j;
		} else {
			flag = 0;
			return 0;
		}
	}

}