package lotto.domain.lotto;

public class LottoSizeException extends IllegalArgumentException {
    LottoSizeException() {
        super("로또 번호는 6개 이어야만 합니다.");
    }
}
