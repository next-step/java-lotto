package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoWinningStatistics;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.RankResult;
import lotto.domain.YieldCalculator;
import lotto.dto.LottosDto;
import lotto.dto.RankStatisticsDto;

public class LottoController {
    private final LottoMachine lottoMachine;

    public LottoController(LottoMachine lottoMachine) {
        this.lottoMachine = lottoMachine;
    }

    public long numberOfLottosToBuy(long fee) {
        return new Money(fee).lottoQuantity();
    }

    public LottosDto buyLottos(long lottoQuantity) {
        Lottos purchasedLottos = lottoMachine.createLottos(lottoQuantity);
        return LottosDto.valueOf(purchasedLottos);
    }

    public RankStatisticsDto informRankStatistics(LottosDto lottosDto, List<Integer> winnerLotto, long cost) {
        RankResult rankResult = createLottoWinningStatistics(winnerLotto).informStatistics(lottosDto.toLottos());
        double yield = YieldCalculator.calculate(cost, rankResult);
        return RankStatisticsDto.valueOf(rankResult, yield);
    }

    private LottoWinningStatistics createLottoWinningStatistics(List<Integer> winnerLotto) {
        return new LottoWinningStatistics(new Lotto(winnerLotto.toArray(Integer[]::new)));
    }
}
