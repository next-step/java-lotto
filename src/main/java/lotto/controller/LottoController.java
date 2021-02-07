package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoMatcher;
import lotto.domain.LottoNumber;
import lotto.domain.LottoTickets;
import lotto.domain.Money;
import lotto.domain.PlayersLotto;
import lotto.domain.WinningLotto;
import lotto.util.ROICalculator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final Lotto lotto;
    private final LottoGenerator lottoGenerator;
    private final LottoMatcher lottoMatcher;
    private Money money;
    private LottoTickets purchasedTickets;
    private WinningLotto winningLotto;

    public LottoController() {
        inputView = new InputView();
        lotto = new WinningLotto();
        lottoGenerator = new LottoGenerator();
        lottoMatcher = new LottoMatcher();
    }

    public void start() {
        money = inputView.getMoneyToBuyLotto();
        int manualCnt = inputView.getManualLottoCnt();
        List<String> manualLottoNumberList = inputView.getManualLottoNumberList(manualCnt);
        generatePlayersLotto(LottoTickets.countTicketNumberByMoney(money.getMoney()));
        OutputView.printAllLotto(purchasedTickets);
        generateWinnerLotto();
        lottoMatcher.checkAllTickets(purchasedTickets, winningLotto);
        printLottoResult();
    }

    private void generatePlayersLotto(int numberOfTicket) {
        List<PlayersLotto> generatedPlayersLotto = lottoGenerator
            .generateLottoTickets(numberOfTicket);
        purchasedTickets = new LottoTickets(generatedPlayersLotto);
    }

    private void generateWinnerLotto() {
        String winningLottoNumber = inputView.getLottoAnswer();
        List<LottoNumber> winningLotto = lotto.getLottoNumbersWithSplitting(winningLottoNumber);
        int bonusBall = inputView.getBonusBall();
        LottoNumber bonusNumber = new LottoNumber(bonusBall);
        this.winningLotto = new WinningLotto(bonusNumber, winningLotto);
    }

    private void printLottoResult() {
        OutputView.printWinningResult(lottoMatcher.getPrizeBoard());
        int revenue = ROICalculator.getRevenue(lottoMatcher.getPrizeBoard());
        OutputView
            .printReturnOnInvestment(ROICalculator.calculateReturnOnInvestment(revenue, money.getMoney()));
    }
}
