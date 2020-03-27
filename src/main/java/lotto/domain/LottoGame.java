package lotto.domain;

import java.util.Set;

public class LottoGame {
    private static final int GAME_PRICE = 1000;
    private final int gameCount;
    private Money money;

    public LottoGame(int money) {
        this.money = new Money(money);
        this.gameCount = Math.floorDiv(money, GAME_PRICE);
    }

    public int getGameCount() {
        return gameCount;
    }

    public Set<Integer> getGameResults(Set<Integer> winningNumber) {
        return winningNumber;
    }
}
