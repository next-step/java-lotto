package lotto;

import lotto.dto.Lottos;
import lotto.service.LottoService;
import lotto.service.StatisticPrinter;

public class LottoGame {
    private final LottoService lottoService;
    private final StatisticPrinter statisticPrinter;

    public LottoGame(LottoService lottoService, StatisticPrinter statisticPrinter) {
        this.lottoService = lottoService;
        this.statisticPrinter = statisticPrinter;
    }

    public void start() {
        Lottos boughtLottos = lottoService.buyLottos();
        if (boughtLottos.isEmpty()) {
            return;
        }
        statisticPrinter.printStatistic(boughtLottos);
    }
}
