package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoMatcher;
import lotto.domain.LottoNumber;
import lotto.domain.LottoTickets;
import lotto.domain.PlayersLotto;
import lotto.domain.WinnerLotto;
import lotto.util.ROICalculator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final Lotto lotto;
    private final LottoGenerator lottoGenerator;
    private final LottoMatcher lottoMatcher;
    private int money;
    private LottoTickets purchasedTickets;
    private WinnerLotto winnerLotto;

    public LottoController() {
        inputView = new InputView();
        lotto = new WinnerLotto();
        lottoGenerator = new LottoGenerator();
        lottoMatcher = new LottoMatcher();
    }

    public void start() {
        money = inputView.getMoneyToBuyLotto();
        generatePlayersLotto(LottoTickets.countTicketNumberByMoney(money));
        OutputView.printAllLotto(purchasedTickets);
        generateWinnerLotto();
        lottoMatcher.checkAllTickets(purchasedTickets, winnerLotto);
        printLottoResult();
    }

    private void generatePlayersLotto(int numberOfTicket) {
        List<PlayersLotto> generatedPlayersLotto = lottoGenerator
            .generateLottoTickets(numberOfTicket);
        purchasedTickets = new LottoTickets(generatedPlayersLotto);
    }

    private void generateWinnerLotto() {
        String winningLottoNumber = inputView.getLottoAnswer();
        List<LottoNumber> winningLotto = lotto.getWinnerLottoWithSplitting(winningLottoNumber);
        int bonusBall = inputView.getBonusBall();
        LottoNumber bonusNumber = new LottoNumber(bonusBall);
        winnerLotto = new WinnerLotto(bonusNumber, winningLotto);
    }

    private void printLottoResult() {
        OutputView.printWinningResult(lottoMatcher.getPrizeBoard());
        int revenue = ROICalculator.getRevenue(lottoMatcher.getPrizeBoard());
        OutputView
            .printReturnOnInvestment(ROICalculator.calculateReturnOnInvestment(revenue, money));
    }
}
