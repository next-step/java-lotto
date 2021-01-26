package calculator;

public class StringCalculator {

    public static void main(String[] args) {

    }

    public int add (String text) {
        if (InputValidator.checkIsNullOrIsEmpty(text)) {
            return 0;
        }
        return 1;
    }
}
