package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoService;
import lotto.domain.WinnerType;
import lotto.view.InputView;
import lotto.view.ResultView;
import util.Parser;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        int buyAmount = inputView.createBuyAmount();

        LottoService lottoService = new LottoService();
        int number = lottoService.buyTicket(buyAmount);
        List<Lotto> lottos = lottoService.createLottoTickets(number);

        resultView.printBuyTicketNumber(number);
        resultView.printBuyLottos(lottos);

        String winnerNumbers = inputView.createWinnerNumbers();
        Lotto winnerLotto = new Lotto(Parser.convertToInteger(winnerNumbers));
        Map<WinnerType, Integer> winnerStats = lottoService.findWinnerStats(lottos, winnerLotto);
        double yield = lottoService.findYield(winnerStats, number);

        resultView.printWinnerStats(winnerStats);
        resultView.printYield(yield);

    }
}
