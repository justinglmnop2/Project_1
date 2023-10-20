public class LinkedListCustom {
    static Node head;

    public LinkedListCustom() {
        head = null;
    }


    // Method to insert a digit at the end of the linked list
    public void insertDigit(int digit) {
        Node newNode = new Node(digit, null);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public String numberAsLinkedListString() {
        StringBuilder result = new StringBuilder();

        Node current = head;
        while (current != null) {
            result.append(current.value);
            if (current.next != null) {
                result.append(" -> ");
            }
            current = current.next;
        }

        return result.toString();
    }

}
