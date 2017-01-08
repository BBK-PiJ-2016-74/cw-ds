/**
 * Created by Piotr Styk
 */
public class ReturnObjectImpl implements ReturnObject{

    private boolean hasError;
    private ErrorMessage errorMessage;
    private Object object;

    public ReturnObjectImpl(boolean hasError, ErrorMessage errorMessage, Object object) {
        this.hasError = hasError;
        this.errorMessage = errorMessage;
        this.object = object;
    }

    @Override
    public boolean hasError() {
        return this.hasError;
    }

    @Override
    public ErrorMessage getError() {
        return this.errorMessage;
    }

    @Override
    public Object getReturnValue() {
        return this.object;
    }
}
