package lotto.exception;

public class LottoNumberDuplicatedException extends IllegalArgumentException {
    public LottoNumberDuplicatedException() {
        super("LottoNumber 중복은 허용되지 않습니다");
    }
}
