package lotto;

import lotto.models.Lotto;
import lotto.models.LottoStatistics;
import lotto.models.WinningLotto;
import lotto.models.request.PaymentRequest;
import lotto.models.request.WinningLottoRequest;
import lotto.services.LottoService;
import lotto.services.LottoStatisticsService;
import lotto.strategy.NormalPickNumberStrategy;
import lotto.ui.Printer;

import java.util.List;

public class LottoApplication {

    public static void main(String[] args){
        LottoService lottoService = new LottoService();
        LottoStatisticsService lottoStatisticsService = new LottoStatisticsService();

        PaymentRequest paymentRequest = Printer.requestPayment();
        List<Lotto> lottos = lottoService.issueLotto(paymentRequest, new NormalPickNumberStrategy());
        Printer.printLottoNumbers(lottos);

        WinningLottoRequest winningLottoRequest = Printer.requestWinningLotto();
        List<LottoStatistics> lottoStatistics = lottoStatisticsService.getLottoStatistics(lottos, WinningLotto.from(winningLottoRequest));
        Printer.printStatistics(lottoStatistics);

        float revenueRatio = lottoStatisticsService.getRevenueRatio(lottoStatistics, paymentRequest);
        Printer.printRevenueRatio(revenueRatio);
    }
}
