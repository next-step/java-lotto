package calculator;

public class Calculator {
    public long calculate(String text) {
        String[] splitText = text.split(" ");
        long firstOperand = Long.parseLong(splitText[0]);
        String operator = splitText[1];
        long secondOperand = Long.parseLong(splitText[2]);

        return firstOperand + secondOperand;
    }
}
