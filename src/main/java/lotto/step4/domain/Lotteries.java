package lotto.step4.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lotteries {
    private List<Lottery> lotteries;

    public Lotteries(List<Lottery> lotteries) {
        this.lotteries = lotteries;
    }

    public Lotteries(int autoCount, List<Lottery> lotteries) {
        this.lotteries = lotteries;
        while (autoCount-- > 0) {
            this.lotteries.add(LottoCreator.createLotto());
        }
    }

    public List<Lottery> getLotteries() {
        return lotteries;
    }

    public LottoStatistics compareLottoWith(Winning winning) {
        Map<Rank, Integer> lottoStatistics = new HashMap<>();
        for (Lottery lottery : lotteries) {
            Rank rank = winning.match(lottery);
            lottoStatistics.put(rank, lottoStatistics.getOrDefault(rank, 0) + 1);
        }
        return new LottoStatistics(lottoStatistics);
    }

}
