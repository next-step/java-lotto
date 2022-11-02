package Lotto.Lotto;

public class LottoMoney {
    private static final Integer TICKET_PRICE = 1000;

    private final Integer buyMoney;
    private final Integer lottoCount;

    public LottoMoney(Integer buyMoney) {
        this.buyMoney = buyMoney;
        lottoCount = buyMoney / TICKET_PRICE;
    }

    public Integer getBuyMoney() {
        return buyMoney;
    }

    public Integer getLottoCount() {
        return lottoCount;
    }
}
