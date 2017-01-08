/**
 * Created by Piotr Styk
 * LinkedList List implementation with First and no Last
 * First Node is a placeholder and never holds a value.
 * Methods indices are zero based analogous to ArrayList implementation.
 */
public class LinkedList implements List {
    private Node first;
    private int addedElementsCount;

    public LinkedList() {
        this.first = new Node(null);
        this.addedElementsCount = 0;
    }

    @Override
    public ReturnObject add(Object item) {
        if (item == null) {
            //invalid path
            return new ReturnObjectImpl(true, ErrorMessage.INVALID_ARGUMENT, null);
        }
        else {
            Node node = this.first;
            while(node.getNextNode() != null) {
                node = node.getNextNode();
            }
            node.setNextNode(new Node (item));
            this.addedElementsCount++;
            return new ReturnObjectImpl(false, ErrorMessage.NO_ERROR, null);
        }
    }

    @Override
    public boolean isEmpty() {
        if (this.addedElementsCount > 0) {
            return false;
        }
        else {
            return true;
        }
    }

    @Override
    public int size() {
        return this.addedElementsCount;
    }

    @Override
    public ReturnObject get(int index) {
        if (this.size() == 0){
            return new ReturnObjectImpl(true, ErrorMessage.EMPTY_STRUCTURE, null);
        }
        else if (index < 0 || index > this.size()-1) //if no entries, index less than 0, index greater than last element's index
        {
            //invalid path, index out of range
            return new ReturnObjectImpl(true, ErrorMessage.INDEX_OUT_OF_BOUNDS, null);
        }
        else {
            //valid path, valid range
            Node node = this.first;
            for (int i = 0; i <= index; i++){
                node = node.getNextNode();
            }
            return new ReturnObjectImpl(false, ErrorMessage.NO_ERROR, node.getObject());
        }
    }

    @Override
    public ReturnObject remove(int index) {
        if (this.size() == 0){
            return new ReturnObjectImpl(true, ErrorMessage.EMPTY_STRUCTURE, null);
        }
        else if (index < 0 || index > this.size()-1) //if no entries, index less than 0, index greater than last element's index
        {
            //invalid path, index out of range
            return new ReturnObjectImpl(true, ErrorMessage.INDEX_OUT_OF_BOUNDS, null);
        }
        else {
            //valid path, valid range
            //at this point we know there is at least one node
            Node node = this.first;
            for (int i = 0; i < index; i++){ //stop one before index (previous to current)
                node = node.getNextNode();
            }

            //relink
            Node removedNode = node.getNextNode();
            if (removedNode.getNextNode() == null){
                node.setNextNode(null);
            }
            else{
                node.setNextNode(removedNode.getNextNode());
            }

            //decrease item counter
            this.addedElementsCount--;

            return new ReturnObjectImpl(false, ErrorMessage.NO_ERROR, removedNode.getObject());
        }
    }

    @Override
    public ReturnObject add(int index, Object item) {
        if (this.size() == 0){
            return new ReturnObjectImpl(true, ErrorMessage.EMPTY_STRUCTURE, null);
        }
        else if (index < 0 || index > this.size()-1) //if no entries, index less than 0, index greater than last element's index
        {
            //invalid path, index out of range
            return new ReturnObjectImpl(true, ErrorMessage.INDEX_OUT_OF_BOUNDS, null);
        }
        else {
            //valid path, valid range
            //at this point we know there is at least one node

            Node node = this.first;
            for (int i = 0; i < index; i++){ //stop one before index (previous to desired)
                node = node.getNextNode();
            }

            //Relink
            Node newNode = new Node (item);
            newNode.setNextNode(node.getNextNode());
            node.setNextNode(newNode);

            this.addedElementsCount++;
            return new ReturnObjectImpl(false, ErrorMessage.NO_ERROR, null);
        }
    }





    private class Node {
        private Node nextNode;
        private Object o;

        //constructors
        public Node(Object o) {
            nextNode = null;
            this.o = o;
        }

        public Node(Object o, Node nextNode) {
            this.nextNode = nextNode; //we have link to follow
            this.o = o;
        }

        //node iterators
        public Node getNextNode() {
            return this.nextNode;
        }

        public void setNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }

        //node value property get/set pairs
        public Object getObject() {
            return this.o;
        }

        public void setObject(Object o) {
            this.o = o;
        }
    }
}