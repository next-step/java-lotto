package calculator.objects;

public class Number {
    public static boolean isNegative(String text) {
        int number = Integer.parseInt(text);

        return number < 0;
    }
}
