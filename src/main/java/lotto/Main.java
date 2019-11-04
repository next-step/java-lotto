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

        int number = lottoService.buyTicket(InputView.createBuyAmount());
        List<Lotto> lottos = lottoService.createLottoTickets(number);

        ResultView.printBuyTicketNumber(number);
        ResultView.printBuyLottos(lottos);

        WinnerLotto winnerLotto = InputView.createWinnerLotto();
        Map<WinnerType, Integer> winnerStats = lottoService.findWinnerStats(lottos, winnerLotto);
        double yield = lottoService.findYield(winnerStats, number);

        ResultView.printWinnerStats(winnerStats);
        ResultView.printYield(yield);

    }
}
