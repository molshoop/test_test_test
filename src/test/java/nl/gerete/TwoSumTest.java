package nl.gerete;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * @author <a href="mailto:marc.mol@bloomville.nl">Marc Mol</a>
 * Created on 20-04-2021.
 */
public class TwoSumTest {

	TwoSum twoSum = new TwoSum();

	@ParameterizedTest
	@MethodSource(value = {"testValues"})
	public void testSum(int[] nums, int target, int[] result) {
		int[] resultFromCode = twoSum.getSum(nums, target);
		Assertions.assertEquals(result[0], resultFromCode[0]);
		Assertions.assertEquals(result[1], resultFromCode[1]);
	}

	private static Stream<Arguments> testValues() {
		return Stream.of(
			Arguments.of(new int[]{1,2}, 3, new int[]{0,1}),
			Arguments.of(new int[]{3,4,5,6,10}, 11,new int[]{2,3}),
			Arguments.of(new int[]{2,7,11,15}, 9,new int[]{0,1}),
			Arguments.of(new int[]{3,2,4}, 6,new int[]{1,2}),
			Arguments.of(new int[]{3,3}, 6,new int[]{0,1})
		);
	}}
