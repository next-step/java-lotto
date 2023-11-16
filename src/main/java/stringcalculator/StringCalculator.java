package stringcalculator;

public class StringCalculator {
    public int calculate(String text) {
        String[] splitArr = text.split(" ");
        int number1 = Integer.parseInt(splitArr[0]);
        int number2 = Integer.parseInt(splitArr[2]);
        return number1 + number2;
    }
}
