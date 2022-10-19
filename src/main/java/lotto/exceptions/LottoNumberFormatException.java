package lotto.exceptions;

public class LottoNumberFormatException extends NumberFormatException {
    public LottoNumberFormatException(String input) {
        super("숫자 값만 입력할 수 있습니다. 입력값:" + input);
    }
}
