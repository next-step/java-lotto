package lotto;

public class LottoGame {
    private static final int GAME_PRICE = 1000;
    private final int money;
    private final int gameCount;

    public LottoGame(int money) {
        this.money = money;
        this.gameCount = Math.floorDiv(money, GAME_PRICE);
    }

    public int getGameCount() {
        return gameCount;
    }
}
