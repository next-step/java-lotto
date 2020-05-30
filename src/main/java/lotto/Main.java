package lotto;

import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;
import java.util.Set;

public class Main {

    private static LottoShop lottoShop = new LottoShop(new LottoTicketAutoGenerator());
    private static LottoGame lottoGame = new LottoGame();

    public static void main(String[] args) {

        int amount = InputView.inputLottoAmount();

        List<LottoTicket> lottoTickets = lottoShop.buy(amount);
        ResultView.printBuyingTickets(lottoTickets);

        Set<LottoNumber> winningNumbers = InputView.inputWinningNumbers();
        int bonusNumber = InputView.inputBonusNumber();

        int round = 1;
        lottoGame.add(round, winningNumbers, bonusNumber);

        LottoAnalyzer lottoAnalyzer = new LottoAnalyzer(lottoGame, lottoTickets);
        List<LottoRank> lottoRanks = lottoAnalyzer.gradeTicketRank(round);

        ResultView.printLottoRanks(LottoRank.convertLottoRankWithCount(lottoRanks));
        ResultView.printRevenueRate(lottoAnalyzer.calculateRevenueRate(round));

    }
}
