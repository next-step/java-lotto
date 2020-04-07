package lotto.domain.lotto;

public class LottoLineMaxSizeException extends IllegalArgumentException {
    LottoLineMaxSizeException() {
        super("로또는 최대 5개까지의 로또 라인을 포함할 수 있습니다.");
    }
}
