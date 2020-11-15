package lotto;

import lotto.domain.Lotto;
import lotto.service.LottoService;
import lotto.service.StatisticPrinter;

import java.util.List;

public class LottoGame {
    private final LottoService lottoService;
    private final StatisticPrinter statisticPrinter;

    public LottoGame(LottoService lottoService, StatisticPrinter statisticPrinter) {
        this.lottoService = lottoService;
        this.statisticPrinter = statisticPrinter;
    }

    public void start() {
        List<Lotto> boughtLottos = lottoService.buyLottos();
        if (boughtLottos.isEmpty()) {
            return;
        }
        statisticPrinter.printStatistic(boughtLottos);
    }
}
