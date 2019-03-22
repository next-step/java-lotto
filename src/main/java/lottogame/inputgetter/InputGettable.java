package lottogame.inputgetter;

public interface InputGettable<R, P> {
    R getReturnObject(P... parameters);
    void showInputMessage();

    default R get(P... parameters){
        R returnObject;

        try {
            showInputMessage();
            returnObject = getReturnObject(parameters);
        } catch(Exception e) {
            System.out.println(e);
            return get(parameters);
        }

        return returnObject;
    }
}