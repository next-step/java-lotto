package lotto;

import lotto.models.Lotto;
import lotto.models.LottoStatistics;
import lotto.models.WinningLotto;
import lotto.models.request.WinningLottoRequest;
import lotto.services.LottoService;
import lotto.services.LottoStatisticsService;
import lotto.services.PickNumberService;
import lotto.strategy.NormalPickNumberStrategy;
import lotto.ui.Printer;

import java.util.List;

public class LottoApplication {

    public static void main(String[] args){
        LottoService lottoService = new LottoService();
        LottoStatisticsService lottoStatisticsService = new LottoStatisticsService();

        String payment = Printer.requestPayment();
        List<Lotto> lottos = lottoService.issueLotto(Integer.parseInt(payment), new NormalPickNumberStrategy());
        Printer.printLottoNumbers(lottos);

        String winningNumber = Printer.requestWinningNumber();
        int bonusNumber = Printer.requestBonusNumber();
        List<LottoStatistics> lottoStatistics = lottoStatisticsService.getLottoStatistics(lottos, WinningLotto.from(new WinningLottoRequest(winningNumber, bonusNumber)));
        Printer.printStatistics(lottoStatistics);

        float revenueRatio = lottoStatisticsService.getRevenueRatio(lottoStatistics, Integer.parseInt(payment));
        Printer.printRevenueRatio(revenueRatio);
    }
}
