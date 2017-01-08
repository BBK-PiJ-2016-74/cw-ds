/**
 * Created by Piotr Styk
 */
public class StackImpl extends AbstractStack {
    public StackImpl(List list) {
        super(list);
    }

    @Override
    public boolean isEmpty() {
        return this.internalList.isEmpty();
    }

    @Override
    public int size() {
        return this.internalList.size();
    }

    @Override
    public void push(Object item) {
        if (item != null) {
            this.internalList.add(item);
        }
    }

    @Override
    public ReturnObject top() {
        if (this.internalList.isEmpty()){
            return new ReturnObjectImpl(true, ErrorMessage.EMPTY_STRUCTURE, null);
        }
        else {
            return new ReturnObjectImpl(false, ErrorMessage.NO_ERROR, this.internalList.get(this.internalList.size()-1).getReturnValue());
        }
    }

    @Override
    public ReturnObject pop() {
        if (this.internalList.isEmpty()){
            return new ReturnObjectImpl(true, ErrorMessage.EMPTY_STRUCTURE, null);
        }
        else {
            Object o = this.internalList.get(this.internalList.size()-1).getReturnValue();
            this.internalList.remove(this.internalList.size()-1);
            return new ReturnObjectImpl(false, ErrorMessage.NO_ERROR, o);
        }
    }
}
