package lotto.domain;

import static lotto.LottoApplication.LOTTO_COST;

public class LottoFactory {

    public static Lottos createLottos(int buyingAmount) {
        if (buyingAmount < LOTTO_COST) {
            throw new IllegalArgumentException("구매 금액이 부족합니다.");
        }

        int lottoAmount = buyingAmount / LOTTO_COST;
        return new Lottos(lottoAmount);
    }

}
