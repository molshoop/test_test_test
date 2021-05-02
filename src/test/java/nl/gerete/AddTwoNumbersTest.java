package nl.gerete;

import nl.gerete.util.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * @author <a href="mailto:marc.mol@bloomville.nl">Marc Mol</a>
 * Created on 29-04-2021.
 */
class AddTwoNumbersTest {

	AddTwoNumbers m_addTwoNumbers = new AddTwoNumbers();

	@ParameterizedTest
	@MethodSource(value = {"testValues"})
	public void testAddTwoNumbers(int[] int1, int[] int2, int[] answer) {

		ListNode l1 = getListNode(int1);
		ListNode l2 = getListNode(int2);

		ListNode result = m_addTwoNumbers.addTwoNumbers(l1, l2);

		int i = 0;
		while (result.next != null) {
			Assertions.assertEquals(answer[i++], result.val);
			result = result.next;
		}
	}

	private ListNode getListNode(int[] numbers) {

		ListNode listNode1 = new ListNode(numbers[numbers.length-1]);
		for (int i = numbers.length -2; i >=0 ; i--) {
			listNode1 = new ListNode(numbers[i], listNode1);
			System.out.println("numbers = " + numbers[i]);
		}
		return listNode1;
	}

	private static Stream<Arguments> testValues() {
		return Stream.of(
			Arguments.of(new int[]{2,4,3}, new int[]{5,6,4}, new int[]{7,0,8}),
			Arguments.of(new int[]{0}, new int[]{0}, new int[]{0}),
			Arguments.of(new int[]{9,9,9,9,9,9,9}, new int[]{9,9,9,9}, new int[]{8,9,9,9,0,0,0,1}),
			Arguments.of(new int[]{9}, new int[]{1,9,9,9,9,9,9,9,9,9}, new int[]{0,0,0,0,0,0,0,0,0,0,1})
		);
	}
}
