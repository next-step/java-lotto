package lotto.lotto;

public class LottoMoney {
    private static final Integer TICKET_PRICE = 1000;

    private final Integer buyMoney;

    public LottoMoney(Integer buyMoney) {
        this.buyMoney = buyMoney;
    }

    public Integer getBuyMoney() {
        return buyMoney;
    }

    public LottoCount getLottoCount() {
        return new LottoCount(buyMoney / TICKET_PRICE);
    }
}
