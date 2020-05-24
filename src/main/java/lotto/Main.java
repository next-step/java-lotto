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
        int[] winningNumbers = InputView.inputWinningNumbers();
        lottoGame.add(round, winningNumbers);

        ResultView.printLottoRanks(lottoGame.lottoRanks(round, lottoTickets));
        ResultView.printRevenueRate(lottoGame.revenueRate(round, lottoTickets));

    }
}
