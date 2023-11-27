package lotto.controller;

import java.util.List;
import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoWinningStatistics;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.RankResult;
import lotto.domain.YieldCalculator;
import lotto.dto.LottoGameInfoDto;
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

    public RankStatisticsDto informRankStatistics(LottoGameInfoDto lottoGameInfoDto) {
        RankResult rankResult = createLottoWinningStatistics(lottoGameInfoDto.getWinnerLotto(),
                lottoGameInfoDto.getBonusNumber())
                .informStatistics(lottoGameInfoDto.getLottosDto().toLottos());
        double yield = YieldCalculator.calculate(lottoGameInfoDto.getCost(), rankResult);
        return RankStatisticsDto.valueOf(rankResult, yield);
    }

    private LottoWinningStatistics createLottoWinningStatistics(List<Integer> lotto, int bonusNumber) {
        Lotto winnerLotto = new Lotto(lotto.toArray(Integer[]::new));
        return new LottoWinningStatistics(winnerLotto, new Bonus(bonusNumber, winnerLotto));
    }
}
