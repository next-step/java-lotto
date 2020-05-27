package lotto.domain;

import java.util.List;

public class LottoStore {

    public final static int LOTTO_PRICE_PER_ONE = 1000;

    public static List<Lotto> buy(int price) {
        validatePrice(price);
        LottoGenerator lottoGenerator= LottoGenerator.newInstance();
        int count = (int) Math.floor(price / LOTTO_PRICE_PER_ONE);
        return lottoGenerator.generator(count);
    }

    private static void validatePrice(int price) {
        if(price < LOTTO_PRICE_PER_ONE) {
            throw new IllegalArgumentException("입력된 금액이 로또구매 최소금액보다 작습니다.");
        }
    }

}
