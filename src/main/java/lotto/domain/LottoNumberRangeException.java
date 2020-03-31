package lotto.domain;

public class LottoNumberRangeException extends IllegalArgumentException {
    public LottoNumberRangeException() {
        super("로또 번호는 1~45 사이의 수만 가능합니다.");
    }
}
