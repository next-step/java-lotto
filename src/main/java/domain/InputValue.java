package domain;

public class InputValue {
    public static int inputValueValidate(String inputValue) {
        if(inputValue == null)
            return 0;
        if(inputValue.isEmpty())
            return 0;

        return Integer.parseInt(inputValue);
    }
}
