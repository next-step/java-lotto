package lotto.domain;

import java.util.Objects;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-11-09 02:19
 */
public class LottoPurchase {

    private static final int LOTTO_PRICE = 1000;
    private static final int INIT_COUNT = 0;

    private final LottoAmount lottoAmount;
    private final int manualLottoCount;


    public LottoPurchase(LottoAmount lottoAmount) {
        this(lottoAmount, INIT_COUNT);
    }

    public LottoPurchase(LottoAmount lottoAmount, int manualLottoCount) {
        this.lottoAmount = lottoAmount;
        this.manualLottoCount = manualLottoCount;
    }

    public int getAutoLottoCount() {
        return lottoAmount.getAvailableLottoCount() - manualLottoCount;
    }

    public int getManualLottoCount() {
        return manualLottoCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoPurchase that = (LottoPurchase) o;
        return manualLottoCount == that.manualLottoCount &&
                Objects.equals(lottoAmount, that.lottoAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoAmount, manualLottoCount);
    }
}
