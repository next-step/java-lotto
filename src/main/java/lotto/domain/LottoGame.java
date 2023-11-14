package lotto.domain;

import lotto.domain.lotto.Lottos;
import lotto.domain.rankcount.RankCountGroup;
import lotto.domain.wrapper.Numbers;

import java.util.List;

public class LottoGame {

    public static final int LOTTO_PRICE = 1000;

    private Lottos lottos;
    private ProfitCalculator profitCalculator;

    public void createLottos(List<Numbers> numberses) {
        lottos = new Lottos(numberses);
        this.profitCalculator = new ProfitCalculator();
    }

    public RankCountGroup groupByRankCount(Numbers winningNumbers) {
        return lottos.groupByRankCount(winningNumbers);
    }

    public double calculateProfitRate(RankCountGroup rankCountGroup) {
        return profitCalculator.calculateProfitRate((long) lottos.getNumOfLotto() * LOTTO_PRICE, rankCountGroup);
    }
}
