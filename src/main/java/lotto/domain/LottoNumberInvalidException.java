package lotto.domain;

public class LottoNumberInvalidException extends IllegalArgumentException {
    public LottoNumberInvalidException() {
        super("로또번호는 숫자만 입력할 수 있습니다.");
    }
}
