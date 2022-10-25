package lotto;

import lotto.models.IssuedLotto;
import lotto.models.Lotto;
import lotto.models.LottoStatistics;
import lotto.models.WinningLotto;
import lotto.models.request.LottoNumberRequest;
import lotto.models.request.PaymentRequest;
import lotto.models.request.WinningLottoRequest;
import lotto.services.LottoService;
import lotto.services.LottoStatisticsService;
import lotto.strategy.NormalPickNumberStrategy;
import lotto.ui.Printer;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoApplication {

    private static final LottoService lottoService = new LottoService();
    private static final LottoStatisticsService lottoStatisticsService = new LottoStatisticsService();

    public static void main(String[] args){
        PaymentRequest paymentRequest = Printer.requestPayment();
        List<LottoNumberRequest> lottoNumberRequests = Printer.requestManualNumber();
        List<IssuedLotto> lottos = issueLottos(paymentRequest, lottoNumberRequests);
        Printer.printLottoNumbers(lottos, lottoNumberRequests.size());

        WinningLottoRequest winningLottoRequest = Printer.requestWinningLotto();
        List<LottoStatistics> lottoStatistics = lottoStatisticsService.getLottoStatistics(lottos, WinningLotto.from(winningLottoRequest));
        Printer.printStatistics(lottoStatistics);

        float revenueRatio = lottoStatisticsService.getRevenueRatio(lottoStatistics, paymentRequest);
        Printer.printRevenueRatio(revenueRatio);
    }

    private static List<IssuedLotto> issueLottos(PaymentRequest paymentRequest, List<LottoNumberRequest> lottoNumberRequests) {
        List<IssuedLotto> manualLottos = lottoService.issueManualLotto(lottoNumberRequests);
        List<IssuedLotto> randomLottos = lottoService.issueRandomLotto(paymentRequest, new NormalPickNumberStrategy());
        return Stream.concat(manualLottos.stream(), randomLottos.stream()).collect(Collectors.toList());
    }
}
