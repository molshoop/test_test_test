package nl.gerete.util;

/**
 * @author <a href="mailto:marc.mol@bloomville.nl">Marc Mol</a>
 * Created on 29-04-2021.
 */
public class ListNode {
	public int val;

	public ListNode next;

	public ListNode() {}

	public ListNode(int val) {
		this.val = val;
	}

	public ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}

