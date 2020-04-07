package lotto.domain.lotto;

public class LottoNumbersSizeException extends IllegalArgumentException {
    LottoNumbersSizeException() {
        super("로또 번호는 6개 이어야만 합니다.");
    }
}
