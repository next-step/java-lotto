package lotto;

public class LottoPrice {
    private final int price = 1000;

    public int howManyPass(int receiveMoney) {
        return receiveMoney / price;
    }
}
