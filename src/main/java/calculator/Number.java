package calculator;

public class Number {

    private Number() {}

    public static int valueOf(String input) {
        int number = Integer.parseInt(input);
        if (number < 0) {
            throw new RuntimeException();
        }

        return number;
    }
}
