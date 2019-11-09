package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoService;
import lotto.domain.WinnerLotto;
import lotto.domain.WinnerType;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        LottoService lottoService = new LottoService();

        int count = lottoService.buyTicket(InputView.createBuyAmount());
        int manualCount = InputView.createBuyManualCount();

        List<Lotto> manualLottos = InputView.createBuyManualLottos(manualCount);
        List<Lotto> lottos = lottoService.createLottoTickets(count, manualLottos);

        ResultView.printBuyTicketNumber(count);
        ResultView.printBuyLottos(lottos);

        WinnerLotto winnerLotto = InputView.createWinnerLotto();
        Map<WinnerType, Integer> winnerStats = lottoService.findWinnerStats(lottos, winnerLotto);
        double yield = lottoService.findYield(winnerStats, count);

        ResultView.printWinnerStats(winnerStats);
        ResultView.printYield(yield);

    }
}
