package lottogame.service;

import lottogame.service.reponse.LottoPurchaseResponse;

public class LottoService {

    public LottoPurchaseResponse buy(int money) {

        if (money % 1000 != 0) {
            throw new IllegalArgumentException(String.format("money는 1000원으로 나누어 떨어져야 합니다 money: \"%d\"", money));
        }

        return null;
    }
}
