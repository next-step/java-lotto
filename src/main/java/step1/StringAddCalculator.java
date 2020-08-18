package step1;

public class StringAddCalculator {

    public static int splitAndSum(String input) {
        validate(input);
        return 1;
    }

    public static int validate(String input){
        validateNull(input);
        validateOneNumber();
        validateNegativeNumber();

    }
    public static int validateNull(String input){
        if(input == null || input.trim().isEmpty()){
            return 0;
        }
    }

    public static int validateOneNumber(String input){
        if(input.length() == 1 && ){

        }
    }

}
