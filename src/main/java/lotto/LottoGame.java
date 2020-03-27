package lotto;

public class LottoGame {
    private static final int GAME_PRICE = 1000;
    private final int money;
    private final int gameCount;

    public LottoGame(int money) {
        this.money = validate(money);
        this.gameCount = Math.floorDiv(money, GAME_PRICE);
    }

    private int validate(int money) {
        if (money < 1000) {
            throw new IllegalArgumentException("구입 금액은 1000원 이상이어야 합니다");
        }
        return money;
    }

    public int getGameCount() {
        return gameCount;
    }
}
