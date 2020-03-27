package lotto;

public class StringConverter {

    public static Money convertStringToMoney(String input) {
        return new Money(Long.parseLong(input));
    }
}
