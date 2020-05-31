package step2.domain;

/*
 * LottoGame
 * ver. 1.0
 * 2020.05.31
 * Copyright ...
 */
public class LottoGame {

    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_DRAW_LIMIT = 6;

    public static int buyLotto(int payMoney) {

        int gameCount = Number.getGameCountByPayMoney(payMoney, LOTTO_PRICE);

        return gameCount;

    }


}
