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

    public int price(){
        return price;
    }

    public int lottoCount(){
        return price / LOTTO_PRICE;
    }

    public boolean greaterThanPrice(List<List<Integer>> lists) {
        return lottoCount() < lists.size();
    }

    public LottoPrice pay() {
        return new LottoPrice(price - LOTTO_PRICE);
    }
}
