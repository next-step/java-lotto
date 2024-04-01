package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.LottoPrice;
import lotto.domain.LottoTicket;
import lotto.domain.WinLotto;

public class LottoResultManager {

    private final Map<LottoPrice, Integer> lottoResult;
    private final int purchaseAmount;

    public LottoResultManager(List<LottoTicket> tickets, WinLotto winLotto) {
        this.lottoResult = new HashMap<>();
        this.purchaseAmount = tickets.size() * 1000;
        calculateLottoResult(tickets, winLotto);
    }

    private Map<LottoPrice, Integer> calculateLottoResult(List<LottoTicket> tickets,
        WinLotto lotto) {

        for (LottoTicket ticket : tickets) {
            LottoPrice price = lotto.price(ticket);
            lottoResult.put(price, lottoResult.getOrDefault(price, 0) + 1);
        }

        return lottoResult;
    }


    public double calculateReturnRate() {
        double winningMoney = 0;
        for (Map.Entry<LottoPrice, Integer> item : lottoResult.entrySet()) {
            winningMoney += item.getKey().getPrice() * item.getValue();
        }
        return Math.round(winningMoney / (purchaseAmount * 1000) * 100.0) / 100.0;
    }

    public Map<LottoPrice, Integer> getLottoResult() {
        return lottoResult;
    }
}
