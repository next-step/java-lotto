package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.LottoPrice;
import lotto.domain.LottoTicket;

public class LottoResultManager {

    private Map<Integer, Integer> lottoResult = new HashMap<>();

    public LottoResultManager() {
        lottoResult.put(3, 0);
        lottoResult.put(4, 0);
        lottoResult.put(5, 0);
        lottoResult.put(6, 0);
    }

    public Map<Integer, Integer> calculateLottoResult(List<LottoTicket> tickets,
            List<Integer> winningNumbers) {
        LottoTicket winningTicket = LottoTicket.createTicket(winningNumbers);

        for (LottoTicket ticket : tickets) {
            int count = ticket.count(winningTicket.getNumbers());
            lottoResult.put(count, lottoResult.getOrDefault(count, 0) + 1);
        }
        return lottoResult;
    }

    public double calculateReturnRate(Map<Integer, Integer> result, int purchaseAmount) {
        double winningMoney = calculateWinningMoney(result);
        return Math.round(winningMoney / purchaseAmount * 100.0) / 100.0;

    }

    private double calculateWinningMoney(Map<Integer, Integer> result) {
        double winningMoney = 0;
        for (Map.Entry<Integer, Integer> item : result.entrySet()) {
            winningMoney += LottoPrice.findPrice(item.getKey()).getPrice() * item.getValue();
        }
        return winningMoney;
    }
}
