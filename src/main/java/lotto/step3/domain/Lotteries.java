package lotto.step3.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lotteries {
    private List<Lottery> lotteries;

    public Lotteries(int lottoCount) {
        lotteries = new ArrayList<>();
        while (lottoCount-- > 0) {
            lotteries.add(LottoCreator.createLotto());
        }
    }

    public Lotteries(List<Lottery> lotteries) {
        this.lotteries = lotteries;
    }

    public List<Lottery> getLotteries() {
        return lotteries;
    }

    public LottoStatistics compareLottoWith(Winning winning) {
        Map<Rank, Integer> lottoStatistics = new HashMap<>();
        for (Lottery lottery : lotteries) {
            int countOfMatch = lottery.matchWinningNumber(winning);
            boolean isContainBonusBall = lottery.containBonus(winning);
            Rank rank = Rank.getRankBy(countOfMatch, isContainBonusBall);
            lottoStatistics.put(rank, lottoStatistics.getOrDefault(rank, 0) + 1);
        }
        return new LottoStatistics(lottoStatistics);
    }

}
