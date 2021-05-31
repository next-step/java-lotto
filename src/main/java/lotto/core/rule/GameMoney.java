package lotto.core.rule;

public class GameMoney {
    public static final int PRICE_OF_ONE_GAME = 1000;

    private final int money;

    public GameMoney(int money) {
        if (isValidateMinimumAmount(money)) {
            throw new RuntimeException(String.format("구입 최소금액은 %d원 입니다.", PRICE_OF_ONE_GAME));
        }

        this.money = money;
    }

    public int numberOfGamesPlayed() {
        return money / PRICE_OF_ONE_GAME;
    }

    public int change() {
        return money % PRICE_OF_ONE_GAME;
    }

    public boolean isCange() {
        return change() > 0;
    }

    private static boolean isValidateMinimumAmount(int money) {
        return money < PRICE_OF_ONE_GAME;
    }
}
