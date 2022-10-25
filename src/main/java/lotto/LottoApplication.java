package lotto;

import lotto.models.IssuedLotto;
import lotto.models.LottoStatistics;
import lotto.models.WinningLotto;
import lotto.models.request.IssueLottoRequest;
import lotto.models.request.WinningLottoRequest;
import lotto.services.LottoService;
import lotto.services.LottoStatisticsService;
import lotto.strategy.NormalPickNumberStrategy;
import lotto.ui.Printer;

import java.util.List;

public class LottoApplication {

    private static final LottoService lottoService = new LottoService();
    private static final LottoStatisticsService lottoStatisticsService = new LottoStatisticsService();

    public static void main(String[] args){
        IssueLottoRequest issueLottoRequest = Printer.requestIssueLotto();
        List<IssuedLotto> lottos = issueLottos(issueLottoRequest);
        Printer.printLottoNumbers(lottos);

        WinningLottoRequest winningLottoRequest = Printer.requestWinningLotto();
        List<LottoStatistics> lottoStatistics = lottoStatisticsService.getLottoStatistics(lottos, WinningLotto.from(winningLottoRequest));
        Printer.printStatistics(lottoStatistics);

        float revenueRatio = lottoStatisticsService.getRevenueRatio(lottoStatistics, issueLottoRequest);
        Printer.printRevenueRatio(revenueRatio);
    }

    private static List<IssuedLotto> issueLottos(IssueLottoRequest issueLottoRequest) {
        return lottoService.issueLottos(issueLottoRequest, new NormalPickNumberStrategy());
    }
}
