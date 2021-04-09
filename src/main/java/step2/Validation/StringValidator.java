package step2.Validation;

public class StringValidator {

    public static int parseStringToInt(String number){
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }
}
