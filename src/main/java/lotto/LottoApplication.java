package lotto;

import lotto.models.Lotto;
import lotto.models.LottoStatistics;
import lotto.services.LottoService;
import lotto.services.LottoStatisticsService;
import lotto.services.PickNumberService;
import lotto.ui.Printer;

import java.util.List;

public class LottoApplication {

    public static void main(String[] args){
        PickNumberService pickNumberService = new PickNumberService();
        LottoService lottoService = new LottoService(pickNumberService);

        String payment = Printer.requestPayment();
        List<Lotto> lottos = lottoService.issueLotto(Integer.parseInt(payment) / 1000);
        Printer.printLottoNumbers(lottos);

        String winningNumber = Printer.requestWinningNumber();
        LottoStatisticsService lottoStatisticsService = new LottoStatisticsService();
        List<LottoStatistics> lottoStatistics = lottoStatisticsService.getLottoStatistics(lottos, winningNumber);
        Printer.printStatistics(lottoStatistics);

        float revenueRatio = lottoStatisticsService.getRevenueRatio(lottoStatistics, Integer.parseInt(payment));
        Printer.printRevenueRatio(revenueRatio);
    }
}
