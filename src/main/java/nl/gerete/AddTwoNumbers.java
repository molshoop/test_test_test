package nl.gerete;

import nl.gerete.util.ListNode;

import java.math.BigInteger;

/**
 * @author <a href="mailto:marc.mol@bloomville.nl">Marc Mol</a>
 * Created on 29-04-2021.
 */
public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		
		BigInteger result1 = getNumber(l1);
		BigInteger result2 = getNumber(l2);
		BigInteger totaal = result1.add(result2);
		return getListNode(totaal);
	}

	private BigInteger getNumber(ListNode l1) {
		BigInteger multiply = new BigInteger("10");
		BigInteger result1 = new BigInteger("" + l1.val);
		while(l1.next != null) {
			l1 = l1.next;
			result1 = result1.add(multiply.multiply(new BigInteger(""+ l1.val)));
			multiply = multiply.multiply(new BigInteger("10"));
		}
		return result1;
	}

	private ListNode getListNode(BigInteger number) {

		int[] result = new int[100];
		int i = 0;
		BigInteger nine = new BigInteger("9");
		BigInteger ten = new BigInteger("10");
		while (number.compareTo(nine) > 0) {
			BigInteger result1 = number.mod(ten);
			result[i] = result1.intValue();
			number = number.divide(ten);
			i++;
		}
		result[i] = number.intValue();

		ListNode listNode = new ListNode((int)result[i--]);
		while (i>=0) {
			listNode = new ListNode((int)result[i--], listNode);
		}
		return listNode;
	}

}
