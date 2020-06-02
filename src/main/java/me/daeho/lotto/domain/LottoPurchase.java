package me.daeho.lotto.domain;

import java.util.List;

public class LottoPurchase {
    private final List<LottoTicket> manualTickets;
    private final int amount;
    private final int manualCount;

    public LottoPurchase(int amount, int manualCount, List<LottoTicket> manualTickets) {
        this.amount = amount;
        this.manualCount = manualCount;
        this.manualTickets = manualTickets;
    }

    public static LottoPurchase of(int amount, int manualCount, List<LottoTicket> manualTickets) {
        return new LottoPurchase(amount, manualCount, manualTickets);
    }

    public int randomCount(LottoPrice lottoPrice) {
        int randomCount = amount - getManualAmount(lottoPrice);
        return randomCount / lottoPrice.value();
    }

    private int getManualAmount(LottoPrice lottoPrice) {
        return lottoPrice.value() * manualCount;
    }

    public int amount() {
        return amount;
    }

    public List<LottoTicket> manualTickets() {
        return manualTickets;
    }

}
