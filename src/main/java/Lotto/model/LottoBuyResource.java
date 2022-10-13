package Lotto.model;

import java.util.Objects;

import static Lotto.LottoConstant.LOTTO_PRICE;

public class LottoBuyResource {

    private static final String PRICE_ERROR_MESSAGE = "로또는 한개당 천원입니다.";
    private static final String MANUAL_LOTTO_COUNT_ERROR_MESSAGE = "수동으로 구매할 로또 수가 구매한 개수보다 클 수는 없습니다.";
    private static final String MANUAL_LOTTO_COUNT_MINUS_ERROR_MESSAGE = "수동으로 구매할 로또 수가 음수일 수는 없습니다.";
    private final int lottoPrice;
    private final int autoLottoCount;
    private final int manualLottoCount;

    public LottoBuyResource(int lottoPrice, int manualLottoCount) {
        validate(lottoPrice, manualLottoCount);
        this.lottoPrice = lottoPrice;
        this.manualLottoCount = manualLottoCount;
        this.autoLottoCount = lottoPrice / LOTTO_PRICE - manualLottoCount;
    }

    private void validate(int lottoPrice, int manualLottoCount) {
        if (lottoPrice % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(PRICE_ERROR_MESSAGE);
        }
        if (lottoPrice / LOTTO_PRICE - manualLottoCount < 0) {
            throw new IllegalArgumentException(MANUAL_LOTTO_COUNT_ERROR_MESSAGE);
        }
        if (manualLottoCount < 0) {
            throw new IllegalArgumentException(MANUAL_LOTTO_COUNT_MINUS_ERROR_MESSAGE);
        }
    }

    public int getAutoLottoCount() {
        return this.autoLottoCount;
    }

    public int getManualLottoCount() {
        return this.manualLottoCount;
    }

    public int getLottoPrice() {
        return this.lottoPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoBuyResource)) return false;
        LottoBuyResource that = (LottoBuyResource) o;
        return getLottoPrice() == that.getLottoPrice() && getAutoLottoCount() == that.getAutoLottoCount() && getManualLottoCount() == that.getManualLottoCount();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLottoPrice(), getAutoLottoCount(), getManualLottoCount());
    }
}
