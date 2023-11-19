package stringCalculator;

import java.util.ArrayList;
import java.util.List;

public class SplitString {
    private static final String SPLIT_DELIMITER = " ";
    private static final String SUM_OPERATOR = "+";
    private static final String SUBTRACTION_OPERATOR = "-";
    private static final String MULTIPLICATION_OPERATOR = "*";
    private static final String DIVISION_OPERATOR = "/";

    public static List<String> splitInputString(String input){
        List<String> splitStrings = new ArrayList<>();

        for(String string : splitWithDelimiter(input)) {
            addElement(splitStrings, string);
        }

        return splitStrings;
    }

    private static String[] splitWithDelimiter(String input){
        if(input == null || input == " "){
            throw new IllegalArgumentException();
        }
        return input.split(SPLIT_DELIMITER);
    }

    private static void addElement(List<String> splitStrings, String string){
        if(isNumeric(string) || isOperator(string)) {
            splitStrings.add(string);
        }
    }

    private static boolean isNumeric(String string){
        return Character.isDigit(string.charAt(0));
    }

    private static boolean isOperator(String string){
        if(!(string.equals(SUM_OPERATOR) || string.equals(SUBTRACTION_OPERATOR) || string.equals(MULTIPLICATION_OPERATOR) || string.equals(DIVISION_OPERATOR))) {
            throw new IllegalArgumentException();
        }
        return true;
    }

}
