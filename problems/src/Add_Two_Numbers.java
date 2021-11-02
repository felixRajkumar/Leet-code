

/*
    Problem breakdown - Add two numbers and return them in proper order

    Solution breakdown - Similar to normal addition , iterate both the linked lists at the same time
    
                       - Have a carry variable to add if there is any carry during iteration

                       - If any of the linked list during iteration has come to an end , then take its value as 0;
*/



class Add_Two_Numbers {


	// Definition for singly-linked list.
	public class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {


		// Temp variables for iteration
		ListNode temp1 = l1;

		ListNode temp2 = l2;

		ListNode node = new ListNode(0);

		//During iteration if we use the original node, it will point to the last node but we have to return the starting point of node. so we use a temp ref for iteration
		ListNode temp = node;

		int carry = 0, sum = 0;

		//Either of the variables could have reached the end point during iteration so we are using OR operator
		while(temp1 != null || temp2 != null)
		{
			int value_1 = 0;

			int value_2 = 0;

			if(temp1 != null)
			{
				value_1 = temp1.val;
				temp1 = temp1.next;
			}

			if(temp2 != null)
			{
				value_2 = temp2.val;
				temp2 = temp2.next;
			}

			sum = value_1 + value_2 + carry;

			carry = sum / 10;

			ListNode newNode = new ListNode(sum%10);

			temp.next = newNode;

			temp = temp.next;
		}

		if(carry != 0)
		{
			ListNode newNode = new ListNode(carry);

			temp.next = newNode;
		}

		return node.next;
	}
}