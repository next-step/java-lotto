package step2.util;

public class StringParser {

    public static int parseStringToInt(String number){
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }
}
