package stringcalculator;

public class ExpressionParser {
    public static boolean isNumber(String stringNumber) {
        try {
            Integer.parseInt(stringNumber);
            return true;
        } catch(Exception e){
            return false;
        }
    }


}
