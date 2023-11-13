import java.util.ArrayList;
import java.util.List;

public class SplitString {
    private static final String SPLIT_DELIMITER = " ";

    public static List<Integer> splitNumber(String input) {
        List<Integer> numbers = new ArrayList<>();

        for(String string : splitWithDelimiter(input)){
            if(isNumeric(string)){
                numbers.add(Integer.parseInt(string));
            }
        }
        return numbers;
    }

    public static List<String> splitOperator(String input){
        List<String> operators = new ArrayList<>();

        for(String string : splitWithDelimiter(input)){
            if(!isNumeric(string) && isOperator(string)){
                operators.add(string);
            }
        }
        return operators;
    }

    private static boolean isNumeric(String string){
        return Character.isDigit(string.charAt(0));
    }

    private static String[] splitWithDelimiter(String input){
        if(input == null || input == " "){
            throw new IllegalArgumentException();
        }
        return input.split(SPLIT_DELIMITER);
    }

    private static boolean isOperator(String string){
        if(!(string.equals("+") || string.equals("-") || string.equals("*") || string.equals("/"))) {
            throw new IllegalArgumentException();
        }

        return true;
    }

}
