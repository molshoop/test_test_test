package nl.gerete;

import nl.gerete.util.ListNode;

/**
 * @author <a href="mailto:marc.mol@bloomville.nl">Marc Mol</a>
 * Created on 29-04-2021.
 */
public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		
		long result1 = getNumber(l1);
		long result2 = getNumber(l2);
		return getListNode(result1 + result2);
	}

	private long getNumber(ListNode l1) {
		long multiply = 10;
		long result1 = l1.val;
		while(l1.next != null) {
			l1 = l1.next;
			result1 += l1.val * multiply;
			multiply *= 10;
		}
		return result1;
	}

	private ListNode getListNode(long number) {
		long[] result = new long[100];
		int i = 0;
		while (number > 9) {
			result[i] = number % 10;
			number = number / 10;
			i++;
		}
		result[i] = number;

		ListNode listNode = new ListNode((int)result[i--]);
		while (i>=0) {
			listNode = new ListNode((int)result[i--], listNode);
		}
		return listNode;
	}
}
