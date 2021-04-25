package nl.gerete;

/**
 * @author <a href="mailto:marc.mol@bloomville.nl">Marc Mol</a>
 * Created on 20-04-2021.
 */
public class TwoSum {

	public int[] getSum(int[] numbs, int target) {

		int posFirstNumber;
		int posSecondNumber;
		for(int i = 0; i < numbs.length; i++) {
			posFirstNumber = i;
			int firstNumber = numbs[i];
			for(int j = i + 1; j < numbs.length; j++) {
				posSecondNumber = j;
				int secondNumber = numbs[j];
				if (firstNumber + secondNumber == target) {
					return new int[]{posFirstNumber, posSecondNumber};
				}
			}
		}
		return new int[]{};
	}
}
