package lotto;

public class StringConverter {
    public static PositiveNumber convertStringToPositiveNumber(String input) {
        return new PositiveNumber(Integer.parseInt(input));
    }
}
