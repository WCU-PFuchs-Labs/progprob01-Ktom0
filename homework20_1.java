/*
Given a sorted linked list, delete all nodes that have duplicate
numbers, leaving only distinct numbers from the original list.In this 
program, you need to 
(1) read 5 numbers and set them in a linkedlist in order
(2) delete duplicate

Example 1:
input: 1,2,3,3,5
output: head-->1-->2-->3-->5-->null

Example 2:
input: 1,1,1,2,3
output: head-->1-->2-->3-->null

Please complete the following program to fullfil the function.
*/
public class homework20_1
{
   public static void main(String[] args)
   {
      Scanner sc = new Scanner(System.in);

      LinkedList list = new LinkedList();

      for (int i = 0; i < 5; i++) {
         int num = sc.nextInt();
         SortedInOrder(list, num);
      }

      deleteDuplicates(list);

      System.out.println(list);   
   }

    public static void SortedInOrder(LinkedList list, int value)
   {
      ListNode newNode = new ListNode(value);

      if (list.head == null || value < list.head.value) {
         newNode.next = list.head;
         list.head = newNode;
         return;
      }

      ListNode curr = list.head;
      while (curr.next != null && curr.next.value <= value) {
         curr = curr.next;
      }

      newNode.next = curr.next;
      curr.next = newNode;
   }   
   public static void deleteDuplicates(LinkedList llist)
   {
       ListNode curr = llist.head;

      while (curr != null && curr.next != null) {
         if (curr.value == curr.next.value) {
            curr.next = curr.next.next;   
         }
         else {
            curr = curr.next;            
         }
      }
   }
}

class ListNode
{
   int value;
   ListNode next;
   ListNode(int v){value = v;}
}

class LinkedList
{
   ListNode head;
   public String toString()
   {
      String nodeData = "";
      ListNode ref = head;
      while(ref != null)
      {
         nodeData += ref.value + "-->";
         ref = ref.next;
      }
      return "head-->"+nodeData+"null";
   }
}
