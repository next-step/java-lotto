package study.step3.domain.dto;

import study.step3.domain.exception.LottoException;

public class LottoCount {

    private final int lottoCount;

    public LottoCount(int lottoCount) {
        validate(lottoCount);
        this.lottoCount = lottoCount;
    }

    private void validate(int lottoCount) {
        if (!isValid(lottoCount)) {
            throw new LottoException("로또 수량은 0이상 이어야 합니다.");
        }
    }

    private boolean isValid(int lottoCount) {
        return lottoCount >= 0;
    }

    public LottoCount calculateAutoLottoCount(int purchaseCount) {
        return new LottoCount(purchaseCount - lottoCount);
    }

    public int count() {
        return lottoCount;
    }
}
