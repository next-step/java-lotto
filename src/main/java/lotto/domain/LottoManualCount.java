package lotto.domain;

public class LottoManualCount extends LottoCount {
    private static final String NOT_GREATER_THAN_INPUT_NUMBER_MESSAGE = "로또 수동 개수는 로또를 구매한 개수보다 클 수 없습니다.";

    public LottoManualCount(String count) {
        super(count);
    }

    public LottoManualCount(int count) {
        super(count);
    }

    public LottoManualCount validateCount(LottoCount lottoCount) {
        if (this.number() > lottoCount.number()) {
            throw new IllegalArgumentException(NOT_GREATER_THAN_INPUT_NUMBER_MESSAGE);
        }
        return this;
    }
}
