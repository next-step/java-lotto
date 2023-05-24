package lotto.domain;

import java.util.List;

import static lotto.constant.Constants.LOTTO_PRICE;

public class LottoPrice {
    private final int price;
    public LottoPrice(int price) {
        checkPrice(price);
        this.price = price;
    }

    private static void checkPrice(int price) {
        if (LOTTO_PRICE > price) {
            throw new IllegalArgumentException("로또 구매 비용이 부족합니다.");
        }
    }

    public int lottoCount(){
        return price / LOTTO_PRICE;
    }

    public LottoPrice pay() {
        return new LottoPrice(price - LOTTO_PRICE);
    }

    public boolean buyPossible(int manualLottoCount) {
        return lottoCount() > manualLottoCount;
    }
}
