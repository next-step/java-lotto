package lotto;

import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class Main {

    private static LottoShop lottoShop = new LottoShop();
    private static LottoGame lottoGame = new LottoGame();

    public static void main(String[] args) {

        int amount = InputView.inputLottoAmount();

        List<LottoTicket> lottoTickets = lottoShop.buy(amount);
        ResultView.printBuyingTickets(lottoTickets);

        int round = 1;
        WinningLotto winningLotto = WinningLotto.of(InputView.inputWinningNumbers());
        lottoGame.add(round, winningLotto);

        LottoAnalyzer lottoAnalyzer = new LottoAnalyzer(lottoGame);
        ResultView.printLottoRanks(lottoAnalyzer.gradeTicket(round, lottoTickets));
        ResultView.printRevenueRate(lottoAnalyzer.calculateRevenueRate(round, lottoTickets));

    }
}
