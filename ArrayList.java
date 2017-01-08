/**
 * Created by Piotr Styk
 * ArrayList will auto grow/shrink based on add and remove method triggers.
 * list init is maintained such as there is always one and only one slot available for new entry.
 * once slot is filled with add or shrunk with remove, array is re-initialized
 */
public class  ArrayList implements List {
    private Object[] arrayList;
    private int addedElementsCount;

    public ArrayList() {
        this.addedElementsCount = 0;
        this.arrayList = new Object[1];
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
            return new ReturnObjectImpl(false, ErrorMessage.NO_ERROR, this.arrayList[index]);
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
            Object o = this.arrayList[index]; //note sought item object for return

            //decrease actual item counter.
            this.addedElementsCount--; //this will increase list of valid elements

            //ReDimension and bubble from new index
            Object[] tmpOldListClone = new Object[this.addedElementsCount]; //this will decrease by one and still leave one empty at the end for add new.
            for (int i = 0; i < this.addedElementsCount; i++){
                if (i < index) {
                    tmpOldListClone[i] = this.arrayList[i];
                }
                else if (i >= index){
                    tmpOldListClone[i] = this.arrayList[i+1];
                }
            }

            this.arrayList = tmpOldListClone;

            return new ReturnObjectImpl(false, ErrorMessage.NO_ERROR, o);
        }
    }

    @Override
    public ReturnObject add(int index, Object item) {
        if (item == null) {
            //invalid path
            return new ReturnObjectImpl(true, ErrorMessage.INVALID_ARGUMENT, null);
        }
        else if (this.size() == 0){
            return new ReturnObjectImpl(true, ErrorMessage.EMPTY_STRUCTURE, null);
        }
        else if (index < 0 || index > this.size()-1){
            //invalid path, index out of range
            return new ReturnObjectImpl(true, ErrorMessage.INDEX_OUT_OF_BOUNDS, null);
        }
        else {
            //valid path

            //increment actual item counter.
            this.addedElementsCount++; //this will increase list of valid elements

            //ReDimension and bubble from new index
            Object[] tmpOldListClone = new Object[this.addedElementsCount + 1]; //this will increase one for the future end spot
            for (int i = 0; i < this.addedElementsCount; i++){
                if (i < index) {
                    tmpOldListClone[i] = this.arrayList[i];
                }
                else if (i == index) {
                    tmpOldListClone[i] = item;
                }
                else if (i > index){
                    tmpOldListClone[i] = this.arrayList[i-1];
                }
            }

            this.arrayList = tmpOldListClone;

            return new ReturnObjectImpl(false, ErrorMessage.NO_ERROR, null);
        }
    }

    @Override
    public ReturnObject add(Object item) {

        if (item == null) {
            //invalid path
            return new ReturnObjectImpl(true, ErrorMessage.INVALID_ARGUMENT, null);
        }
        else {
            //valid path
            //Add to list, element count before increment so equals to index (free slot at end)
            this.arrayList[this.addedElementsCount] = item;

            //If add success, increment actual item counter.
            this.addedElementsCount++;

            //ReDimension
            //init new array as one slot larger, for future new
            Object[] tmpList = new Object[this.addedElementsCount + 1];
            for (int i = 0; i < this.addedElementsCount; i++){
                tmpList[i] = this.arrayList[i];
            }
            this.arrayList = tmpList;

            return new ReturnObjectImpl(false, ErrorMessage.NO_ERROR, null);
        }

    }


}
