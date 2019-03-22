package lottogame.inputgetter;

public interface InputGettable<T,O> {
    T getReturnObject(O... object);
    void showInputMessage();

    default T get(O... parameters){
        T returnObject = null;

        try {
            showInputMessage();
            returnObject = getReturnObject(parameters);
        } catch(Exception e) {
            System.out.println(e + "\n");
            return get(parameters);
        }

        return returnObject;
    }
}