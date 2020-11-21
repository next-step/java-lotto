package study.lotto.core.exception;

public class LottoNumberCountNotMatchingException extends RuntimeException {

    private static final String message = "로또 번호 또는 당첨 번호는 6개를 입력해주세요.";

    public LottoNumberCountNotMatchingException() {
        super(message);
    }

}
