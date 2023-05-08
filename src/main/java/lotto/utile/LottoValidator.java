package lotto.utile;

import java.util.regex.Pattern;

public class LottoValidator {
    public static void validateMoney(int money) {
        if (money < 1000 || money % 1000 != 0) {
            throw new IllegalArgumentException("금액은 1000 단위로 입력해 주시기 바랍니다.");
        }
    }

    public static void checkEmptyString(String text) {
        if(text.isBlank() || text == null) {
            throw new IllegalArgumentException("당첨번호가 비어있습니다.");
        }
    }

    public static void checkLotOfNumber(String[] sWinnerNumber) {
        if(sWinnerNumber.length != 6) {
            throw new IllegalArgumentException("당첨번호를 6개 입력해주시기 바랍니다.");
        }
    }

    public static void checkIsNumber(String Number) {
        if (!Pattern.matches("^[0-9]*$", Number)) {
            throw new IllegalArgumentException("당첨번호는 숫자로 입력해주시기 바랍니다.");
        }
    }

    public static void checkNumberRange(String text) {
        if (!(Integer.parseInt(text) > 0 && Integer.parseInt(text) < 46)) {
            throw new IllegalArgumentException("당첨번호는 1부터 45까지의 숫자로 입력해주시기 바랍니다.");
        }
    }
}
