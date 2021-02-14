public class linkedlist {

    private class Node {
        private int data = 0;
        private Node next = null;

        Node(int data) {
            this.data = data;
        }
    }

    private Node head = null;
    private Node tail = null;
    private int NumberOfNodes = 0;

    public int size() {
        return this.NumberOfNodes;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    protected void handelZeroSize(Node node) {
        this.head = node;
        this.tail = node;
    }

    // ==================================================

    protected void addFirstNode(Node node) {
        if (size() == 0)
            handelZeroSize(node);
        else {
            node.next = this.head;
            this.head = node;
        }

        this.NumberOfNodes++;
    }

    public void addFirst(int data) {
        Node node = new Node(data);
        addFirstNode(node);
    }

    // ==================================================

    protected void addLastNode(Node node) {
        if (size() == 0)
            handelZeroSize(node);
        else {
            this.tail.next = node;
            this.tail = node;
        }

        this.NumberOfNodes++;
    }

    public void addLast(int data) {
        Node node = new Node(data);
        addLastNode(node);
    }

    // ==================================================

    protected void addNodeAt(Node node, int idx) {
        if (idx == 0)
            addFirstNode(node);
        else if(idx==size()-1) return addLast();   
        else {
            Node nodeAt = getNodeAt(idx - 1);
            Node forw = nodeAt.next;

            nodeAt.next = node;
            node.next = forw;
            this.NumberOfNodes++;
        }
    }

    public void addAt(int data, int idx) throws Exception {
        if (idx < 0 || idx > size()) {
            throw new Exception("Invalid Index");
        }

        Node node = new Node(data);
        addNodeAt(node, idx);

    }

    // ==================================================

    protected Node getNodeAt(int idx) {
        Node temp = this.head;
        while (idx-- > 0) {
            temp = temp.next;
        }

        return temp;
    }

    // ==================================================

    protected void handelSize1() {
        this.head = null;
        this.tail = null;
    }

    protected Node removeFirstNode() {
        Node temp = head;
        if (size() == 1)
            handelSize1();
        else
            this.head = this.head.next;

        temp.next = null;
        this.NumberOfNodes--;
        return temp;
    }

    public int removeFirst() throws Exception {
        if (size() == 0) {
            throw new Exception("LinkedList Is Empty");
        }

        Node node = removeFirstNode();
        return node.data;
    }

    // ==================================================

    protected Node removeLastNode() {
        Node temp = tail;
        if (size() == 1)
            handelSize1();
        else {
            Node secondLastNode = getNodeAt(size() - 2);
            secondLastNode.next = null;
            this.tail = secondLastNode;
        }

        this.NumberOfNodes--;
        return temp;
    }

    public int removeLast() throws Exception {
        if (size() == 0) {
            throw new Exception("LinkedList Is Empty");
        }

        Node node = removeLastNode();
        return node.data;
    }
   //=================
   protected Node removeNodeAt(int data, int idx){
         if(idx==0) removeFirst();
         else if(idx==size()-1) return removeLast();
      Node getAt= getNodeAt(idx-1); 
    Node remove=getAt.next;
    Node forw=remove.next;
    getAt.next=forw;
    remove.next=null;
    this.NumberOfNodes--;
    return remove;
   }
    public Node removeAt(int data, int idx)throws Exception{
        if(idx<0||idx>size()){
            throw new Exception("Invalid Exception");
        }
        if(idx==0) removeFirst();
        Node temp=removeNodeAt(data,idx);
        return temp;
   }
   //====================
   public Node getFirst()throws Exception{
       if(size()==0){
           
       }
   }

}