package calculator.domain;

public class Calculator {

    private static final String DELIMITER_POSITION = " ";
    private static final String PLUS = "+";
    private static final String SUBTRACT = "-";
    private static final String MULTIPLY = "*";
    private static final String DIVIDE = "/";
    private static final int START_NUMBER = 0;

    public static int calculator(String rawString) {
        String[] seperateString = rawString.split(DELIMITER_POSITION);
        int result = Integer.parseInt(seperateString[START_NUMBER]);
        for (int i = 1; i < seperateString.length-1; i+=2) {
            if (PLUS.equals(seperateString[i])) {
                result += Integer.parseInt(seperateString[i+1]);
                continue;
            }
            if (MULTIPLY.equals(seperateString[i])) {
                result *= Integer.parseInt(seperateString[i+1]);
                continue;
            }
            if (SUBTRACT.equals(seperateString[i])) {
                result -= Integer.parseInt(seperateString[i+1]);
                continue;
            }
            if (DIVIDE.equals(seperateString[i])) {
                result /= Integer.parseInt(seperateString[i+1]);
            }
        }
         return result;
    }
}
