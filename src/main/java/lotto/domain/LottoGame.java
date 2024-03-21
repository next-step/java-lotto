package lotto.domain;

public class LottoGame {

    private static final int PRICE_PER_GAME = 1000;
    public int convertToGameUnit(int fee) {
        return fee/PRICE_PER_GAME;
    }
}
