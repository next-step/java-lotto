package lotto.domain;

public class LottoPrice {
    public static final String CAN_NOT_BUY_LOTTO = "로또를 살 수 없는 금액입니다.";
    public static final String CAN_NOT_BUY_LOTTO_AMOUNT = "로또는 1000원 단위로 구입 가능합니다.";

    public static final int GAME_PRICE = 1000;
    private final int gameMoney;

    public LottoPrice(int gameMoney) {
        this.gameMoney = validateGameMoney(gameMoney);
    }

    private int validateGameMoney(int gameMoney) {
        if (gameMoney <= 0) {
            throw new IllegalArgumentException(CAN_NOT_BUY_LOTTO);
        }
        if (gameMoney % 1000 != 0) {
            throw new IllegalArgumentException(CAN_NOT_BUY_LOTTO_AMOUNT);
        }
        return gameMoney;
    }

    public int getGameMoney() {
        return gameMoney;
    }

    public String calculateEarnRate(int prizeMoney) {
        double rate = (double) prizeMoney / gameMoney;
        return String.format("%.2f", Math.floor(rate * 100) / 100);
    }
}
