package calculator;

public class Calculator {
    public int calculator(String rawString) {
        String[] seperateString = rawString.split(" ");
        int result = Integer.parseInt(seperateString[0]) + Integer.parseInt(seperateString[2]);
        return result;
    }
}
