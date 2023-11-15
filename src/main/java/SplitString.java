import java.util.ArrayList;
import java.util.List;

public class SplitString {
    private static final String SPLIT_DELIMITER = " ";
    private static final String SUM_OPERATOR = "+";
    private static final String SUBTRACTION_OPERATOR = "-";
    private static final String MULTIPLICATION_OPERATOR = "*";
    private static final String DIVISION_OPERATOR = "/";

    public List<String> splitStrings;

    public SplitString(String input){
        splitStrings = new ArrayList<>();

        for(String string : splitWithDelimiter(input)) {
            addElement(string);
        }
    }

    public List<String> splitString(){
        return splitStrings;
    }

    private static String[] splitWithDelimiter(String input){
        if(input == null || input == " "){
            throw new IllegalArgumentException();
        }
        return input.split(SPLIT_DELIMITER);
    }

    private void addElement(String string){
        if(isNumeric(string) || isOperator(string)) {
            splitStrings.add(string);
        }
    }

    private boolean isNumeric(String string){
        return Character.isDigit(string.charAt(0));
    }

    private boolean isOperator(String string){
        if(!(string.equals(SUM_OPERATOR) || string.equals(SUBTRACTION_OPERATOR) || string.equals(MULTIPLICATION_OPERATOR) || string.equals(DIVISION_OPERATOR))) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    public int stringOperate(){
        int result = Integer.parseInt(splitStrings.get(0));

        for(int i=1; i<splitStrings.size(); i+=2){
            result = Calculator.operate(splitStrings.get(i), result, Integer.parseInt(splitStrings.get(i +1)));
        }

        return result;
    }

}
