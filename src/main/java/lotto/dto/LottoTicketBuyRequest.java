package lotto.dto;

import java.util.List;

public class LottoTicketBuyRequest {
    private List<List<Integer>> manualNumbers;
    private int buyAutomaticCount;

    public LottoTicketBuyRequest(List<List<Integer>> manualNumbers, int buyAutomaticCount) {
        this.manualNumbers = manualNumbers;
        this.buyAutomaticCount = buyAutomaticCount;
    }

    public List<List<Integer>> getManualNumbers() {
        return manualNumbers;
    }

    public int getBuyAutomaticCount() {
        return buyAutomaticCount;
    }
}
