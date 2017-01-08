/**
 * Created by Peter S
 */
public class ImprovedStackImpl implements ImprovedStack {
    private StackImpl si;
    private List l;

    public ImprovedStackImpl(List list) {
        this.l = list;
        this.si = new StackImpl(list);
    }


    /**
     * Returns a copy of this stack with the items reversed, the top
     * elements on the original stack is at the bottom of the new
     * stack and viceversa.
     *
     * @return a copy of this stack with the items reversed.
     */
    @Override
    public ImprovedStack reverse() {
        return null;
    }


    /**
     * Removes the given object from the stack if it is
     * there. Multiple instances of the object are all removed.
     *
     * Classes implementing this method must use method .equals() to
     * check whether the item is in the stack or not.
     *
     * @param object the object to remove
     */
    @Override
    public void remove(Object object) {
        if (this.si.size() == 0 || object == null) {
            return;
        }

        for (int i = 0; i < this.si.size(); i++){
            if (this.l.get(i).getReturnValue().equals(object)){
                this.l.remove(i);
            }
        }

        this.si = new StackImpl(this.l);
    }

    @Override
    public boolean isEmpty() {
        return this.si.isEmpty();
    }

    @Override
    public int size() {
        return this.si.size();
    }

    @Override
    public void push(Object item) {
        this.si.push(item);
    }

    @Override
    public ReturnObject top() {
        return this.si.top();
    }

    @Override
    public ReturnObject pop() {
        return this.si.pop();
    }
}
