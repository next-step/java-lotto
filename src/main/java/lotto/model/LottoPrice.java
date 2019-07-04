package lotto.model;

import lotto.enumset.InitEnum;

public class LottoPrice {

    private final int lottoPrice;

    public LottoPrice(int lottoPrice) {
        this.lottoPrice = validation(lottoPrice);
    }

    public int lottoAutoCount(int inputLottoManualGames) {
        return lottoPrice / InitEnum.LOTTO_DEFAULT_PRICE.value() - inputLottoManualGames;
    }

    public int getLottoPrice() {
        return this.lottoPrice;
    }

    private int validation(int lottoPrice) {
        int lottoOneGamePrice = InitEnum.LOTTO_DEFAULT_PRICE.value();
        if (lottoPrice % lottoOneGamePrice > 0) {
            throw new IllegalStateException("로또 금액은 1000원 단위로 구매 하셔야 합니다.");
        }
        return lottoPrice;
    }

}
