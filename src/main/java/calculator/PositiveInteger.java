package calculator;

public class PositiveInteger {

    public static int toPositiveInteger(String item) {
        return toInt(item);
    }

    private static int toInt(String item) {
        int number;

        try {
            number = Integer.parseInt(item);
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }

        if (number < 0) {
            throw new IllegalArgumentException();
        }

        return number;
    }

}
