package domain;

public class InputValidation {
    public static int inputValueValidate(String inputValue) {
        if(inputValue == null)
            return 0;
        if(inputValue.isEmpty())
            return 0;
        return 1;
    }
}
