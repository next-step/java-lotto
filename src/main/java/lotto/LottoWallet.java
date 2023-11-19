package lotto;

import java.util.List;

public class LottoWallet {

    private final List<Lotto> lottos;

    private final int totalPurchaseAmount;

    public LottoWallet(List<Lotto> lottos) {
        this(lottos, 0);
    }

    public LottoWallet(List<Lotto> lottos, int totalPurchaseAmount) {
        this.totalPurchaseAmount = totalPurchaseAmount;
        this.lottos = lottos;
    }


    public static LottoWallet from(List<Lotto> lottos) {
        return new LottoWallet(lottos);
    }

    public int remainTicketsCount() {
        return lottos.size();
    }

    public Lotto oneTicket(int index) {
        return lottos.get(index);
    }

    public MoneyWallet withdrawMoney(MoneyWallet moneyWallet) {
        return moneyWallet.withdraw(totalPurchaseAmount);
    }

    public int totalPurchaseAmount() {
        return totalPurchaseAmount;
    }

}
