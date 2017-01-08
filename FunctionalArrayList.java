/**
 * Created by Piotr Styk
 */
public class FunctionalArrayList extends ArrayList implements FunctionalList{


    public FunctionalArrayList() {
        super();
    }

    @Override
    public ReturnObject head() {
        if (this.size() == 0){
            return new ReturnObjectImpl(true, ErrorMessage.EMPTY_STRUCTURE, null);
        }
        else {
            //valid path, valid range
            return this.get(0);
        }
    }

    @Override
    public FunctionalList rest() {
        FunctionalList faList = new FunctionalArrayList();
        for (int i = 1; i < this.size(); i++){
            faList.add (super.get(i).getReturnValue());
        }
        return faList;
    }
}
