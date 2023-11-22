package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoWinningMachine {

    private final Map<Rank, Integer> rankCounts;
    private final Lotto winningLotto;
    private final LottoNumber bonusNumber;

    public LottoWinningMachine(int number, Integer... numbers) {
        this(new Lotto(numbers), new LottoNumber(number));
    }

    public LottoWinningMachine(Lotto winningLotto, LottoNumber bonusNumber) {
        this.rankCounts = new EnumMap<>(Rank.class);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public Map<Rank, Integer> getRankCounts(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            int matchCount = lotto.matchCount(winningLotto);

            Rank rank = Rank.rankByCount(matchCount, lotto.contains(bonusNumber));

            rankCounts.put(rank, rankCounts.getOrDefault(rank, 0) + 1);
        }

        return rankCounts;
    }

    public double calculateRateOfResult(Map<Rank, Integer> result, int amount) {
        long sumOfPrizeMoney = 0L;

        for (Map.Entry<Rank, Integer> rankCounts : result.entrySet()) {
            Rank rank = rankCounts.getKey();
            sumOfPrizeMoney += (long) rank.getPrizeMoney() * rankCounts.getValue();
        }

        return new BigDecimal(sumOfPrizeMoney).divide(new BigDecimal(amount), 2, RoundingMode.HALF_UP).doubleValue();
    }
}
