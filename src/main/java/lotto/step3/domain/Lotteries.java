package lotto.step3.domain;

import java.util.ArrayList;
import java.util.List;

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
        List<Rank> lottoStatistics = new ArrayList<>();
        for (Lottery lottery : lotteries) {
            Rank rank = winning.match(lottery);
            lottoStatistics.add(rank);
        }
        return new LottoStatistics(lottoStatistics);
    }

}
