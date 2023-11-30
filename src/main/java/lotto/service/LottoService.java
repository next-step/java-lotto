package lotto.service;

import java.util.List;
import lotto.domain.AutomaticLottoMachine;
import lotto.domain.LottoWinningStatistics;
import lotto.domain.Lottos;
import lotto.domain.ManualLottoMachine;
import lotto.domain.Money;
import lotto.domain.RankResult;
import lotto.domain.WinnerLotto;
import lotto.domain.WinnerLottoGenerator;
import lotto.domain.YieldCalculator;
import lotto.dto.BuyLottosRequest;
import lotto.dto.CreateRankStatisticsRequest;
import lotto.dto.LottosDto;
import lotto.dto.CreateRankStatisticsResponse;
import lotto.dto.BuyLottosResponse;

public class LottoService {
    private final ManualLottoMachine manualLottoMachine;
    private final AutomaticLottoMachine automaticLottoMachine;

    public LottoService(ManualLottoMachine manualLottoMachine, AutomaticLottoMachine automaticLottoMachine) {
        this.manualLottoMachine = manualLottoMachine;
        this.automaticLottoMachine = automaticLottoMachine;
    }

    public long numberOfAllLottos(long cost) {
        return new Money(cost).lottoQuantity();
    }

    public BuyLottosResponse buyLottos(BuyLottosRequest buyLottosRequest) {
        Lottos manualPurachasedLottos = manualLottoMachine.createLottos(buyLottosRequest.getManualLottos());
        long automaticLottoCount = buyLottosRequest.getNumberOfAllLottos() - buyLottosRequest.getManualLottoCount();
        Lottos automaticPurchasedLottos = automaticLottoMachine.createLottos(automaticLottoCount);
        LottosDto lottosDto = LottosDto.valueOf(manualPurachasedLottos, automaticPurchasedLottos);
        return new BuyLottosResponse(lottosDto, automaticLottoCount);
    }

    public CreateRankStatisticsResponse informRankStatistics(CreateRankStatisticsRequest createRankStatisticsRequest) {
        RankResult rankResult = createLottoWinningStatistics(createRankStatisticsRequest.getWinnerLotto(),
                createRankStatisticsRequest.getBonusNumber())
                .informStatistics(createRankStatisticsRequest.getLottosDto().toLottos());
        double yield = YieldCalculator.calculate(createRankStatisticsRequest.getCost(), rankResult);
        return CreateRankStatisticsResponse.valueOf(rankResult, yield);
    }

    private LottoWinningStatistics createLottoWinningStatistics(List<Integer> lotto, int bonusNumber) {
        return new LottoWinningStatistics(createWinnerLotto(lotto, bonusNumber));
    }

    private WinnerLotto createWinnerLotto(List<Integer> lotto, int bonusNumber) {
        WinnerLottoGenerator winnerLottoGenerator = new WinnerLottoGenerator();
        return winnerLottoGenerator.createWinnerLotto(lotto, bonusNumber);
    }
}
