package lotto.domain;

import java.util.List;

public class LottoWallet {

    private final List<Lotto> lottos;

    private final int totalPurchaseAmount;

    public LottoWallet(List<Lotto> lottos, int totalPurchaseAmount) {
        this.totalPurchaseAmount = totalPurchaseAmount;
        this.lottos = lottos;
    }

    public static LottoWallet of(List<Lotto> lottos, int totalPurchaseAmount) {
        return new LottoWallet(lottos, totalPurchaseAmount);
    }

    public int totalTicketCount() {
        return lottos.size();
    }

    public Lotto oneTicket(int index) {
        return lottos.get(index);
    }

    public int totalPurchaseAmount() {
        return totalPurchaseAmount;
    }

}
