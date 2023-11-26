package lotto.model;

import lotto.model.constants.Dividend;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PurchasedLottos {
    private final List<Lotto> lottos;

    public PurchasedLottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int lottoCount() {
        return this.lottos.size();
    }

    public List<Lotto> lottoList() {
        return this.lottos;
    }

    public int totalPurchasePrice() {
        return this.lottos.size() * Lotto.LOTTO_PRICE;
    }

    public long depositTotalMoney(WinnerNumbers winnerNumbers) {
        long totalMoney = 0;
        for (Lotto lotto : this.lottos) {
            totalMoney += winnerNumbers.winnerMoney(lotto);
        }
        return totalMoney;
    }

    public Map<Dividend, Integer> totalCorrect(WinnerNumbers winnerNumbers) {
        Map<Dividend, Integer> correctCountResult = new HashMap<>();
        for (Lotto lotto : this.lottos) {
            Dividend dividend = winnerNumbers.winResult(lotto);
            correctCountResult.put(dividend, correctCountResult.getOrDefault(dividend, 0) + 1);
        }
        return correctCountResult;
    }
}
