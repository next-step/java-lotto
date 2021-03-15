package lotto;

public class LottoPriceImpl implements LottoPrice {
    private final int price = 1000;
    @Override
    public int howManyPass(int receiveMoney) {
        return receiveMoney / price;
    }
}
