package step1;

public class Validator {

    public static String inputValueTest(String inputValue) {
        if(inputValue.trim().equals("")){
            return "0";
        }
        return inputValue;
    }
}
