package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoMatcher;
import lotto.domain.LottoNumber;
import lotto.domain.LottoTickets;
import lotto.domain.Money;
import lotto.domain.PlayersLotto;
import lotto.domain.PlayersLottoGenerateOption;
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
    private PlayersLottoGenerateOption generateOption;
    private LottoTickets purchasedTickets;
    private WinningLotto winningLotto;

    public LottoController() {
        inputView = new InputView();
        lotto = new WinningLotto();
        lottoGenerator = new LottoGenerator();
        lottoMatcher = new LottoMatcher();
    }

    public void start() {
        money = new Money(inputView.getMoneyToBuyLotto());
        generateOption = new PlayersLottoGenerateOption(
            LottoTickets.countTicketNumberByMoney(money.getMoney()),
            inputView.getManualLottoCnt());
        List<PlayersLotto> manualLottoTickets = generateLottoTicketsByManualInputLottoNumber(
            inputView.getManualLottoNumberList(generateOption.getManualGenerateCnt()));
        generatePlayersLotto(generateOption, manualLottoTickets);
        OutputView.printAllLotto(purchasedTickets, generateOption);
        generateWinnerLotto();
        lottoMatcher.checkAllTickets(purchasedTickets, winningLotto);
        printLottoResult();
    }

    private List<PlayersLotto> generateLottoTicketsByManualInputLottoNumber(List<String> lottoNumbers) {
        List<LottoNumber> ticket;
        List<PlayersLotto> playersManualLotto = new ArrayList<>();
        for (int i = 0; i < lottoNumbers.size(); i++) {
            ticket = lotto.getLottoNumberListWithSplitting(lottoNumbers.get(i));
            playersManualLotto.add(new PlayersLotto(ticket));
        }
        return playersManualLotto;
    }

    private void generatePlayersLotto(PlayersLottoGenerateOption generateOption, List<PlayersLotto> manualLottoTicket) {
        List<PlayersLotto> generatedPlayersLotto = lottoGenerator.generateLottoTickets(generateOption, manualLottoTicket);
        purchasedTickets = new LottoTickets(generatedPlayersLotto);
    }

    private void generateWinnerLotto() {
        String winningLottoNumber = inputView.getLottoAnswer();
        List<LottoNumber> winningLotto = lotto.getLottoNumberListWithSplitting(winningLottoNumber);
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
