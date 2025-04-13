package lotto.domain;

import java.util.List;

public class LottoPurchase {
    private final int purchaseAmount;
    private final int totalTicketCount;
    private final int manualTicketCount;
    private final int autoTicketCount;
    private final List<Lotto> lottoList;

    public LottoPurchase(int purchaseAmount, int totalTicketCount, int manualTicketCount, int autoTicketCount, List<Lotto> lottoList) {
        this.purchaseAmount = purchaseAmount;
        this.totalTicketCount = totalTicketCount;
        this.manualTicketCount = manualTicketCount;
        this.autoTicketCount = autoTicketCount;
        this.lottoList = lottoList;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public int getTotalTicketCount() {
        return totalTicketCount;
    }

    public int getManualTicketCount() {
        return manualTicketCount;
    }

    public int getAutoTicketCount() {
        return autoTicketCount;
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

}