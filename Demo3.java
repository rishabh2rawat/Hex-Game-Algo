package Demo;

import java.util.Scanner;

public class Demo3 {
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
					Demo3.dis(a);

				}

				else if (c % 2 == 1 && a[m][n] != 1 && a[m][n] != 2) {
					a[m][n] = 2;
					Demo3.dis(a);
				}

				else {
					System.out.println("try other one...");
					c--;
				}

				if (c >= 8) {
					// for line search.....
					if (c % 2 == 0) {
						for (int j = 0; j < 5; j++) {
							if (a[0][j] == 1)
								rec1(0, j, 3, a);
							System.out.println(c);

							// System.out.println("calling rec ");
						}
					}
					else {
						for (int i = 0; i < 5; i++) {
							if (a[i][0] == 2)
								rec2(i, 0, 3, a);
							System.out.println(c);

							// System.out.println("calling rec ");
						}
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
//winner 1....
	static void rec1(int i, int j, int m, int a[][]) {
		for (int k = 0; k < 6; k++) {
			if (k == (m + 3) % 6) {
				continue;
			} else {
				if (i == 4) {
					System.out.println("1 winner");
				} else {
					if (goingpath1(i, j, k, a) == true) {
						rec1(updatei1(i, k), updatej1(j, k), k, a);
					}
				}
			}
		}
	}

	static boolean goingpath1(int i, int j, int k, int a[][]) {

		if (a[updatei1(i, k)][updatej1(j, k)] == 1 && flag == 1) {
			return true;
		} else {
			flag = 1;
			return false;
		}

	}

	static int updatei1(int i, int k) {
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

	static int updatej1(int j, int k) {
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
//winner 2...
	static void rec2(int i, int j, int m, int a[][]) {
		for (int k = 0; k < 6; k++) {
			if (k == (m + 3) % 6) {
				continue;
			} else {
				if (j == 4) {
					System.out.println("2 winner");
				} else {
					if (goingpath2(i, j, k, a) == true) {
						rec2(updatei2(i, k), updatej2(j, k), k, a);
					}
				}
			}
		}
	}

	static boolean goingpath2(int i, int j, int k, int a[][]) {

		if (a[updatei2(i, k)][updatej2(j, k)] == 2 && flag == 1) {
			return true;
		} else {
			flag = 1;
			return false;
		}

	}

	static int updatei2(int i, int k) {
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
		} /*else if (k == 5 && i - 1 >= 0) {
			return i - 1;
		}*/ else {
			flag = 0;
			return 0;
		}

	}

	static int updatej2(int j, int k) {
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
		} /*else if (k == 5) {
			return j;
		}*/ else {
			flag = 0;
			return 0;
		}
	}

}