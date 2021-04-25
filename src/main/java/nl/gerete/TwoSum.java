package nl.gerete;

/**
 * @author <a href="mailto:marc.mol@bloomville.nl">Marc Mol</a>
 * Created on 20-04-2021.
 */
public class TwoSum {

	public int[] getSum(int[] numbs, int target) {

		for(int i = 0; i < numbs.length; i++) {
			for(int j = i + 1; j < numbs.length; j++) {
				if (numbs[i] + numbs[j] == target) {
					return new int[]{i, j};
				}
			}
		}
		return new int[]{};
	}
}
