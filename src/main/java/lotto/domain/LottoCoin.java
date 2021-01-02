package lotto.domain;

public class LottoCoin {
    private int coin;

    public void coinCharge() {
        this.coin += 1;
    }

    public int getCoin() {
        return coin;
    }
}
