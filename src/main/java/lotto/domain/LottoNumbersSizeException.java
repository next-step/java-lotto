package lotto.domain;

public class LottoNumbersSizeException extends IllegalArgumentException {
    public LottoNumbersSizeException() {
        super("로또 번호는 6개 이어야만 합니다.");
    }
}
