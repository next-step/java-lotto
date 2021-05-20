package calculator;

public class StringCalculator {

    public StringCalculator() {

    }

    public boolean isNullOrZero(String numberString) {
        return (numberString == null || numberString.equals("0"));
    }
}
