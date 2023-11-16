package lotto.domain;

import lotto.domain.lotto.wrapper.Lottos;
import lotto.domain.rankcount.RankCountGroup;
import lotto.domain.lotto.wrapper.LottoNumbers;

import java.util.List;

public class LottoGame {

    public static final int LOTTO_PRICE = 1000;

    private Lottos lottos;
    private ProfitCalculator profitCalculator;

    public void createLottos(List<LottoNumbers> lottoNumberses) {
        lottos = new Lottos(lottoNumberses);
        this.profitCalculator = new ProfitCalculator();
    }

    public RankCountGroup groupByRankCount(LottoNumbers winningNumbers) {
        return lottos.groupByRankCount(winningNumbers);
    }

    public double calculateProfitRate(RankCountGroup rankCountGroup) {
        return profitCalculator.calculateProfitRate((long) lottos.getNumOfLotto() * LOTTO_PRICE, rankCountGroup);
    }
}
