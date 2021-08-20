package lotto.step4.domain;

import java.util.ArrayList;
import java.util.List;

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

    public List<Lottery> values() {
        return lotteries;
    }

    public LottoStatistics compareLottoWith(Winning winning) {
        List<Rank> ranks = new ArrayList<>();
        for (Lottery lottery : lotteries) {
            Rank rank = winning.match(lottery);
            ranks.add(rank);
        }
        return new LottoStatistics(ranks);
    }

}
