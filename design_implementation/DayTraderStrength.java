
// package design_implementation;
import java.util.Arrays;

public class DayTraderStrength {
	int algorithmAforStrength(int[] profits) {

		int strength = 0;
		int performance = 0;
		int n = profits.length;
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				performance = 0;
				for (int k = i; k <= j; k++) {
					performance = performance + profits[k];
					if (strength < performance) {
						strength = performance;
					}
				}
			}
		}
		return strength;
	}

	public int algorithmBforStrength(int[] profits) {
		int[] performance = new int[profits.length + 1];
		performance[0] = 0;

		for (int i = 1; i < performance.length; i++) {
			int prev = (performance[i - 1] + profits[i - 1]);
			if (prev > profits[i - 1]) {
				performance[i] = prev;
			} else {
				performance[i] = profits[i - 1];
			}
		}

		int strength = 0;
		for (int x = 1; x < performance.length; x++) {
			if (performance[x] > strength)
				strength = performance[x];
		}

		return strength;
	}

	public static void main(String[] args) {
		int profits[] = new int[3000];

		for (int i = 0; i < profits.length; i++) {
			profits[i] = (int) (-10 + Math.random() * 20);
		}
		DayTraderStrength i = new DayTraderStrength();
		System.out.println("dynamic  " + i.algorithmBforStrength(profits));
		System.out.println("brute  " + i.algorithmAforStrength(profits));

	}
}
