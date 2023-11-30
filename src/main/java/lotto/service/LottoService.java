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
import lotto.dto.BuyLottosRq;
import lotto.dto.CreateRankStatisticsRq;
import lotto.dto.LottosDto;
import lotto.dto.CreateRankStatisticsRs;
import lotto.dto.BuyLottosRs;

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

    public BuyLottosRs buyLottos(BuyLottosRq buyLottosRq) {
        Lottos manualPurachasedLottos = manualLottoMachine.createLottos(buyLottosRq.getManualLottos());
        long automaticLottoCount = buyLottosRq.getNumberOfAllLottos() - buyLottosRq.getManualLottoCount();
        Lottos automaticPurchasedLottos = automaticLottoMachine.createLottos(automaticLottoCount);
        LottosDto lottosDto = LottosDto.valueOf(manualPurachasedLottos, automaticPurchasedLottos);
        return new BuyLottosRs(lottosDto, automaticLottoCount);
    }

    public CreateRankStatisticsRs informRankStatistics(CreateRankStatisticsRq createRankStatisticsRq) {
        RankResult rankResult = createLottoWinningStatistics(createRankStatisticsRq.getWinnerLotto(),
                createRankStatisticsRq.getBonusNumber())
                .informStatistics(createRankStatisticsRq.getLottosDto().toLottos());
        double yield = YieldCalculator.calculate(createRankStatisticsRq.getCost(), rankResult);
        return CreateRankStatisticsRs.valueOf(rankResult, yield);
    }

    private LottoWinningStatistics createLottoWinningStatistics(List<Integer> lotto, int bonusNumber) {
        return new LottoWinningStatistics(createWinnerLotto(lotto, bonusNumber));
    }

    private WinnerLotto createWinnerLotto(List<Integer> lotto, int bonusNumber) {
        WinnerLottoGenerator winnerLottoGenerator = new WinnerLottoGenerator();
        return winnerLottoGenerator.createWinnerLotto(lotto, bonusNumber);
    }
}
