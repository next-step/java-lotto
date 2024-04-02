package lotto;

import java.util.HashMap;
import java.util.Map;
import lotto.domain.LottoPrice;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTicketCollection;
import lotto.domain.WinLotto;

public class LottoResultManager {

    private final Map<LottoPrice, Integer> lottoResult;
    private final int purchaseAmount;

    public LottoResultManager(LottoTicketCollection ticketCollection, WinLotto winLotto) {
        this.lottoResult = new HashMap<>();
        this.purchaseAmount = (ticketCollection.getAutoTickets().size()
            + ticketCollection.getManualTickets().size()) * 1000;
        calculateLottoTotalResult(ticketCollection, winLotto);
    }

    private void calculateLottoTotalResult(
        LottoTicketCollection ticketCollection,
        WinLotto lotto) {
        for (LottoTicket manualTicket : ticketCollection.getManualTickets()) {
            LottoPrice price = lotto.price(manualTicket);
            lottoResult.put(price, lottoResult.getOrDefault(price, 0) + 1);
        }

        for (LottoTicket autoTicket : ticketCollection.getAutoTickets()) {
            LottoPrice price = lotto.price(autoTicket);
            lottoResult.put(price, lottoResult.getOrDefault(price, 0) + 1);
        }
    }

    public double calculateReturnRate() {
        double winningMoney = 0;
        for (Map.Entry<LottoPrice, Integer> item : lottoResult.entrySet()) {
            winningMoney += item.getKey().getPrice() * item.getValue();
        }
        return Math.round(winningMoney / purchaseAmount * 100.0) / 100.0;
    }

    public Map<LottoPrice, Integer> getLottoResult() {
        return lottoResult;
    }
}
