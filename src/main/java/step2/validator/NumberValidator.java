package step2.validator;

public class NumberValidator {

    public static void isDigit(String input) {
        boolean isDigit = input.chars().allMatch(Character::isDigit);
        if (!isDigit) {
            throw new IllegalArgumentException("숫자가 아닌 문자가 포함되어있습니다.");
        }
    }
}
