package calculator;

public class Calculator {

    private static final String DELIMITER_POSITION = " ";
    private static final String PLUS = "+";
    private static final String SUBTRACT = "-";
    private static final String MULTIPLY = "*";
    private static final String DIVIDE = "/";

    public int calculator(String rawString) {
        String[] seperateString = rawString.split(DELIMITER_POSITION);
        if (PLUS.equals(seperateString[1])) {
            return Integer.parseInt(seperateString[0]) + Integer.parseInt(seperateString[2]);
        }
        if (MULTIPLY.equals(seperateString[1])) {
            return Integer.parseInt(seperateString[0]) * Integer.parseInt(seperateString[2]);
        }
        if (SUBTRACT.equals(seperateString[1])) {
            return Integer.parseInt(seperateString[0]) - Integer.parseInt(seperateString[2]);
        }
        if (DIVIDE.equals(seperateString[1])) {
            return Integer.parseInt(seperateString[0]) / Integer.parseInt(seperateString[2]);
        }
         return 0;
    }
}
