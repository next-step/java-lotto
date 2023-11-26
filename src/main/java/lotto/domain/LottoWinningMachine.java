package lotto.domain;

import lotto.exceptions.InvalidBonusNumberException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.EnumMap;
import java.util.Map;

public class LottoWinningMachine {

    private final Lotto winningLotto;
    private final LottoNumber bonusNumber;

    public LottoWinningMachine(int number, Integer... numbers) {
        this(new Lotto(numbers), new LottoNumber(number));
    }

    public LottoWinningMachine(Lotto winningLotto, LottoNumber bonusNumber) {
        validateWinningLottoAndBonusNumber(winningLotto, bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    private void validateWinningLottoAndBonusNumber(Lotto winningLotto, LottoNumber bonusNumber) {
        if (winningLotto.contains(bonusNumber)) {
            throw new InvalidBonusNumberException(bonusNumber);
        }
    }

    public Map<Rank, Integer> getRankCounts(Lottos lottos) {
        Map<Rank, Integer> rankCounts = new EnumMap<>(Rank.class);

        for (Lotto lotto : lottos.getLottos()) {
            Rank rank = Rank.rankByCount(lotto.matchCount(winningLotto), lotto.contains(bonusNumber));
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
