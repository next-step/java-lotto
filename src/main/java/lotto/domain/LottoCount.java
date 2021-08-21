package lotto.domain;

import lotto.exception.LottoNumberCountException;

public class LottoCount {
    private final int count;

    public LottoCount(int count) {
        validateCount(count);
        this.count = count;
    }

    public static LottoCount from(Money money) {
        return new LottoCount(money.getLottoCount());
    }

    public static LottoCount of(int manualLottoCount, LottoCount lottoCount) {
        if (lottoCount.count < manualLottoCount) {
            throw new LottoNumberCountException();
        }
        return new LottoCount(manualLottoCount);
    }

    private void validateCount(int count) {
        if (count < 0) {
            throw new LottoNumberCountException();
        }
    }

    public int getAutoLottoCount(LottoCount manualLottoCount) {
        return count - manualLottoCount.count;
    }

    public int getCount() {
        return count;
    }
}
