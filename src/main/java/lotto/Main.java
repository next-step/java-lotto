package lotto;

import lotto.domain.*;
import lotto.domain.ticket.LottoTicket;
import lotto.domain.ticket.LottoTicketAutoGenerator;
import lotto.domain.ticket.LottoTicketManualGenerator;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;
import java.util.Set;

public class Main {

    private static LottoShop lottoShop = new LottoShop(new LottoTicketManualGenerator(), new LottoTicketAutoGenerator());
    private static LottoGame lottoGame = new LottoGame();

    public static void main(String[] args) {

        int amount = InputView.inputLottoAmount();
        int manualLottoAmount = InputView.inputManualLottoAmount();
        int autoLottoAmount = amount - manualLottoAmount;

        List<LottoNumbers> manualLottoNumbers = InputView.inputManualLottoNumbers(manualLottoAmount);

        List<LottoTicket> lottoTickets = lottoShop.buy(manualLottoNumbers, autoLottoAmount);
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
