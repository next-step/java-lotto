package lotto;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class StatisticsReport {

    private final LottoWallet lottoWallet;
    private final Map<Prize, Integer> matchCountByPrize;

    private StatisticsReport(LottoWallet lottoWallet) {
        this.lottoWallet = lottoWallet;
        this.matchCountByPrize = initializationMap();
    }

    public StatisticsReport(LottoWallet lottoWallet, Map<Prize, Integer> matchCountByPrize) {
        this(lottoWallet);
        for (Prize key : matchCountByPrize.keySet()) {
            this.matchCountByPrize.put(key, matchCountByPrize.get(key));
        }
    }

    public static StatisticsReport of(LottoWallet lottoWallet) {
        return new StatisticsReport(lottoWallet);
    }

    private static Map<Prize, Integer> initializationMap() {
        Map<Prize, Integer> matchCountByPrize = new HashMap<>();
        Arrays.stream(Prize.values()).forEach(prize -> {
            matchCountByPrize.put(prize, 0);
        });
        return matchCountByPrize;
    }

    public StatisticsReport report(WinningLotto winningLotto) {
        for (int i = 0; i < lottoWallet.totalTicketCount(); i++) {
            Lotto lotto = lottoWallet.oneTicket(i);
            int matchedCount = winningLotto.compare(lotto);
            Prize prize = Prize.prizeByMatchedCount(matchedCount);
            this.matchCountByPrize.put(prize, Integer.sum(matchCountByPrize.get(prize), 1));
        }
        return this;
    }

    public int countByPrize(Prize prize) {
        return matchCountByPrize.get(prize);
    }

    public int totalPrize() {
        int total = 0;
        for (Prize key : matchCountByPrize.keySet()) {
            if (0 < matchCountByPrize.get(key)) {
                total = total + key.price();
            }
        }
        return total;
    }

    public LottoWallet lottoWallet() {
        return this.lottoWallet;
    }
}
