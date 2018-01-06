package Demo;

import java.util.Scanner;

public class Demo {
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
						Demo.dis(a);

					}

					else if (c % 2 == 1 && a[m][n] != 1 && a[m][n] != 2) {
						a[m][n] = 2;
						Demo.dis(a);
					}

					else {
						System.out.println("try other one...");
						c--;
					}
					
				
					if(c>=9) {
						//for line search.....
						
					}
					c++;
				
			}
			sc.close();
		} catch (Exception e) {
			System.out.println("range is 0-4");
		}

	}

}
