package cc.oakk.lotto.model;

public class MoneyPrize extends LottoPrize<Long> {
    public MoneyPrize(Long prize) {
        super(prize, prize);
    }

    @Override
    public String print() {
        return String.format("%d원", prize);
    }
}
