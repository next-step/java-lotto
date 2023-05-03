package lottoauto;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import lottoauto.domain.LottoService;
import lottoauto.domain.StatisticsService;
import lottoauto.model.Lottos;
import lottoauto.view.InputView;
import lottoauto.view.ResultView;

public class LottoAutoApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        int amount = inputView.inputAmount("구입금액을 입력해 주세요.");

        ResultView resultView = new ResultView();
        LottoService lottoService = new LottoService();
        resultView.printBuyLottoQuantity(lottoService.getQuantity(amount));
        Lottos lottos = lottoService.generateLottoNumber(amount);

        resultView.printLottos(lottos);

        String lastWinningNumber = inputView.inputLastWinningNumber("지난 주 당첨 번호를 입력해 주세요.");

        StatisticsService statisticsService = new StatisticsService(lottos);
        Map<Integer, AtomicInteger> lottoStatisticsMap = statisticsService.calculateStatistics(lastWinningNumber);
        double revenueRate = statisticsService.getRevenueRate(lottoStatisticsMap);

        resultView.printStatistics(lottoStatisticsMap, revenueRate);

    }
}
