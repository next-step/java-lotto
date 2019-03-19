package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoTicket {

    private List<Lotto> lottos;

    public LottoTicket(final int lottosCount) {
        if (lottosCount < 1) {
            throw new IllegalArgumentException();
        }

        this.lottos = new ArrayList<>(lottosCount);

        for (int i = 0; i < lottosCount; i++) {
            this.lottos.add(new Lotto());
        }
    }

    public LottoTicket(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Map<Integer, List<Lotto>> getWinningResult(final List<Integer> winningNumbers) {
        Map<Integer, List<Lotto>> lottoResult = new HashMap<>();

        for (Prize prize : Prize.values()) {
            List<Lotto> winningLottos = new ArrayList<>();

            for (Lotto lotto : this.lottos) {
                int containsCount = lotto.getContainsCount(winningNumbers);

                if (containsCount == prize.getHavingCounts()) {
                    winningLottos.add(lotto);
                }
            }

            lottoResult.put(prize.getHavingCounts(), winningLottos);
        }

        return lottoResult;
    }

    public double getEarningsRate(final Map<Integer, List<Lotto>> lottoResult, final int purchaseAmount) {
        int totalPrizeMoney = 0;
        for (Prize prize : Prize.values()) {
            totalPrizeMoney += lottoResult.get(prize.getHavingCounts()).size() * prize.getMoney();
        }

        return totalPrizeMoney / (double) purchaseAmount;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
