package lotto;

import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;
import java.util.Set;

public class Main {

    private static LottoShop lottoShop = new LottoShop();
    private static LottoGame lottoGame = new LottoGame();

    public static void main(String[] args) {

        int amount = InputView.inputLottoAmount();

        List<LottoTicket> lottoTickets = lottoShop.buy(amount);
        ResultView.printBuyingTickets(lottoTickets);

        Set<LottoNumber> winningNumbers = InputView.inputWinningNumbers();
        int bonusNumber = InputView.inputBonusNumber();

        int round = 1;
        WinningLotto winningLotto = WinningLotto.of(LottoTicket.of(winningNumbers), LottoNumber.of(bonusNumber));
        lottoGame.add(round, winningLotto);

        LottoAnalyzer lottoAnalyzer = new LottoAnalyzer(lottoGame);
        List<LottoRank> lottoRanks = lottoAnalyzer.gradeTicket(round, lottoTickets);

        ResultView.printLottoRanks(LottoRank.convertLottoRankWithCount(lottoRanks));
        ResultView.printRevenueRate(lottoAnalyzer.calculateRevenueRate(round, lottoTickets));

    }
}
