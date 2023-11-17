package lotto.domain;

import lotto.domain.lotto.wrapper.Lottos;
import lotto.domain.lotto.wrapper.WinningNumber;
import lotto.domain.rankcount.RankCountGroup;
import lotto.domain.lotto.wrapper.LottoNumbers;

import java.util.List;

public class LottoGame {

    public static final int LOTTO_PRICE = 1000;

    private final Lottos lottos;
    private final WinningNumber winningNumber;
    private final ProfitCalculator profitCalculator;

    public LottoGame(List<LottoNumbers> lottoNumberses, WinningNumber winningNumber) {
        this.lottos = new Lottos(lottoNumberses);
        this.winningNumber = winningNumber;
        this.profitCalculator = new ProfitCalculator();
    }

    public RankCountGroup groupByRank() {
        return lottos.groupByRank(winningNumber);
    }

    public double calculateProfitRate(RankCountGroup rankCountGroup) {
        return profitCalculator.calculateProfitRate((long) lottos.getNumOfLotto() * LOTTO_PRICE, rankCountGroup);
    }
}
