package Lotto.model;

import static Lotto.LottoConstant.LOTTO_PRICE;

public class LottoBuyResource {

    private static final String PRICE_ERROR_MESSAGE = "로또는 한개당 천원입니다.";
    private static final String MANUAL_LOTTO_COUNT_ERROR_MESSAGE = "수동으로 구매할 로또 수가 구매한 개수보다 클 수는 없습니다.";

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

}
