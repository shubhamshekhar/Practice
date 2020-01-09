public class CustomLinkedList
{
	Node head;
	public static class Node 
	{
		int data;
		Node next;
		Node(int data)
		{
			this.data = data;
			this.next = null;
		}
	}

	public static CustomLinkedList insert(CustomLinkedList list, int data)
	{
		if (list.head==null)
		{
			list.head = new Node(data);
		}
		else
		{
			Node temp = list.head;
			while(temp.next!=null)
			{
				temp = temp.next;
			}
			Node newNode = new Node(data);
			temp.next = newNode;
		}
		return list;
	}

	public static CustomLinkedList delete(CustomLinkedList list, int data)
	{
		if(list.head==null)
		{
			System.out.println("List empty");
			//return list;
		}
		else
		{
			Node temp = list.head;
			Node prev = temp;
			while(temp.data!=data)
			{
				prev = temp;
				temp = temp.next;
			}
			prev.next = temp.next;
		}
		return list;
	}

	public static void traverse(CustomLinkedList list)
	{
		if(list.head == null)
		{
			System.out.print("List empty");
		}
		else
		{
			//System.out.print(list.head.data);
			Node temp = list.head;
			while(temp.next!=null)
			{
				System.out.print("->"+temp.data);
				temp = temp.next;
			}
		}
	}

	public static void main(String args[])
	{
		CustomLinkedList list = new CustomLinkedList();
		list = insert(list,1);
		list = insert(list,2);
		list = insert(list,3);
		list = insert(list,4);
		list = insert(list,5);
		list = insert(list,6);
		list = insert(list,7);
		list = insert(list,8);
		list = insert(list,9);
		list = insert(list,10);
		list = insert(list,11);
		list = insert(list,12);

		traverse(list);
		System.out.println();

		list = delete(list,5);
		traverse(list);
		System.out.println();

	}
}