package lotto.domain;

import lotto.domain.lotto.Lottos;
import lotto.domain.rankcount.RankCountGroup;
import lotto.domain.wrapper.Numbers;

import java.util.List;

public class LottoGame {

    private Lottos lottos;
    private ProfitCalculator profitCalculator;

    public void createLottos(List<Numbers> numberses) {
        lottos = new Lottos(numberses);
        this.profitCalculator = new ProfitCalculator();
    }

    public double calculateProfitRate(long purchase, Numbers winningNumbers) {
        RankCountGroup rankCountGroup = lottos.groupByRankCount(winningNumbers);

        return profitCalculator.calculateProfitRate(purchase, rankCountGroup);
    }
}
