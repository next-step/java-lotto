package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoWinningStatistics;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.RankResult;
import lotto.domain.YieldCalculator;
import lotto.dto.LottosDto;
import lotto.dto.RankResultDto;
import lotto.view.OutputView;

public class LottoController {
    private final LottoMachine lottoMachine;
    private final OutputView outputView;

    public LottoController(LottoMachine lottoMachine, OutputView outputView) {
        this.lottoMachine = lottoMachine;
        this.outputView = outputView;
    }

    public LottosDto buyLottos(long fee) {
        long lottoQuantity = new Money(fee).lottoQuantity();
        outputView.printPurchasedLottoCnt(lottoQuantity);
        Lottos purchasedLottos = lottoMachine.createLottos(lottoQuantity);
        LottosDto lottosDto = LottosDto.valueOf(purchasedLottos);
        outputView.printPurchasedLottos(lottosDto);
        return lottosDto;
    }

    public void informRankStatistics(LottosDto lottosDto, List<Integer> winnerLotto, long cost) {
        List<RankResult> rankResults = createLottoWinningStatistics(winnerLotto).informStatistics(lottosDto.toLottos());
        outputView.printLottoRankStatistics(createRankResultDtos(rankResults));
        outputView.printLottoYield(YieldCalculator.calculate(cost, rankResults));
    }

    private LottoWinningStatistics createLottoWinningStatistics(List<Integer> winnerLotto) {
        return new LottoWinningStatistics(new Lotto(winnerLotto));
    }

    private List<RankResultDto> createRankResultDtos(List<RankResult> rankResults) {
        List<RankResultDto> rankResultDtos = new ArrayList<>();
        for (RankResult rankResult : rankResults) {
            rankResultDtos.add(RankResultDto.valueOf(rankResult));
        }
        return rankResultDtos;
    }
}
