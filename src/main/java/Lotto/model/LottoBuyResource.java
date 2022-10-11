package Lotto.model;

import static Lotto.LottoConstant.LOTTO_PRICE;

public class LottoBuyResource {

    private static final String PRICE_ERROR_MESSAGE = "로또는 한개당 천원입니다.";

    private int lottoPrice;
    private int lottoCount;

    public LottoBuyResource(int lottoPrice) {
        validate(lottoPrice);
        this.lottoPrice = lottoPrice;
        this.lottoCount = lottoPrice / LOTTO_PRICE;
    }

    private void validate(int lottoPrice) {
        if (lottoPrice % LOTTO_PRICE != 0) {
            new IllegalArgumentException(PRICE_ERROR_MESSAGE);
        }
    }

    public int getLottoCount() {
        return this.lottoCount;
    }

    public int getLottoPrice() {
        return this.lottoPrice;
    }

}
