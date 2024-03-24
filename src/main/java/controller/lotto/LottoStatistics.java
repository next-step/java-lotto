package controller.lotto;

import domain.common.Money;
import domain.lotto.LottoPrize;
import domain.lotto.UserLotto;
import domain.lotto.WinningLotto;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class LottoStatistics {
    private Map<LottoPrize, Integer> lottoStatistics;

    public static LottoStatistics from(UserLotto userLotto, WinningLotto winningLotto) {
        return new LottoStatistics(userLotto.createLottoStatistics(winningLotto));
    }

    public LottoStatistics(Map<LottoPrize, Integer> lottoStatistics) {
        this.lottoStatistics = lottoStatistics;
    }

    public Map<LottoPrize, Integer> prize() {
        Map<LottoPrize, Integer> prizeMap = new LinkedHashMap<>();
        prizeMap.put(LottoPrize.FIFTH, lottoStatistics.getOrDefault(LottoPrize.FOURTH, 0));
        prizeMap.put(LottoPrize.FOURTH, lottoStatistics.getOrDefault(LottoPrize.FOURTH, 0));
        prizeMap.put(LottoPrize.THIRD, lottoStatistics.getOrDefault(LottoPrize.THIRD, 0));
        prizeMap.put(LottoPrize.SECOND, lottoStatistics.getOrDefault(LottoPrize.SECOND, 0));
        prizeMap.put(LottoPrize.FIRST, lottoStatistics.getOrDefault(LottoPrize.FIRST, 0));
        return prizeMap;
    }

    public double prizeStatistics(Money money) {
        AtomicLong sum = getPrizeSum();
        return money.divideDoubleMoneyToStringResult(new Money(sum.get()));
    }

    private AtomicLong getPrizeSum() {
        AtomicLong sum = new AtomicLong(0L);
        this.lottoStatistics.forEach((key, value) -> {
            Integer count = lottoStatistics.getOrDefault(key, 0);
            sum.addAndGet(key.getWinningMoney() * count);
        });
        return sum;
    }
}

