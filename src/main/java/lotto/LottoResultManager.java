package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.LottoPrice;
import lotto.domain.LottoTicket;
import lotto.domain.WinLotto;

public class LottoResultManager {

    private final Map<LottoPrice, Integer> lottoResult;

    public LottoResultManager(List<LottoTicket> tickets, WinLotto winLotto) {
        this.lottoResult = new HashMap<>();
        calculateLottoResult(tickets, winLotto);
    }

    private Map<LottoPrice, Integer> calculateLottoResult(List<LottoTicket> tickets,
        WinLotto lotto) {

        for (LottoTicket ticket : tickets) {
            LottoPrice price = ticket.getPrice(lotto);
            lottoResult.put(price, lottoResult.getOrDefault(price, 0) + 1);
        }

        return lottoResult;
    }

    public double calculateReturnRate(int purchaseAmount) {
        double winningMoney = calculateWinningMoney();
        return Math.round(winningMoney / purchaseAmount * 100.0) / 100.0;

    }

    private double calculateWinningMoney() {
        double winningMoney = 0;
        for (Map.Entry<LottoPrice, Integer> item : lottoResult.entrySet()) {
            winningMoney += item.getKey().getPrice() * item.getValue();
        }
        return winningMoney;
    }

    public int getCount(LottoPrice price) {
        Integer count = this.lottoResult.get(price);
        if (count == null) {
            return 0;
        }
        return count;
    }


}
