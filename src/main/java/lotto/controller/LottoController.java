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
import lotto.domain.PurchaseOption;
import lotto.domain.WinningLotto;
import lotto.util.ROICalculator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final LottoGenerator lottoGenerator;
    private final LottoMatcher lottoMatcher;
    private Money money;
    private PurchaseOption purchaseOption;
    private LottoTickets purchasedTickets;
    private WinningLotto winningLotto;

    public LottoController() {
        inputView = new InputView();
        lottoGenerator = new LottoGenerator();
        lottoMatcher = new LottoMatcher();
    }

    public void play() {
        buyLotto();
        generateLottoTickets();
        generateWinningLotto();
        printLottoResult();
    }

    private void buyLotto() {
        money = new Money(inputView.getMoneyToBuyLotto());
        purchaseOption = new PurchaseOption(
            LottoTickets.countTicketNumberByMoney(money.getMoney()),
            inputView.getManualLottoCnt());
    }

    private void generateLottoTickets() {
        List<PlayersLotto> manualLottoTickets = generateManualLotto(
            inputView.getManualLottoNumberList(purchaseOption.getManualGenerateCnt()));
        generatePlayersLottoTickets(purchaseOption, manualLottoTickets);
        OutputView.printAllLotto(purchasedTickets, purchaseOption);
    }

    private List<PlayersLotto> generateManualLotto(List<String> lottoNumbers) {
        List<LottoNumber> ticket;
        List<PlayersLotto> playersManualLotto = new ArrayList<>();
        for (int i = 0; i < lottoNumbers.size(); i++) {
            ticket = Lotto.getLottoNumberListWithSplitting(lottoNumbers.get(i));
            playersManualLotto.add(new PlayersLotto(ticket));
        }
        return playersManualLotto;
    }

    private void generatePlayersLottoTickets(PurchaseOption generateOption, List<PlayersLotto> manualLottoTicket) {
        List<PlayersLotto> generatedPlayersLotto = lottoGenerator.generateLottoTickets(generateOption, manualLottoTicket);
        purchasedTickets = new LottoTickets(generatedPlayersLotto);
    }

    private void generateWinningLotto() {
        String winningLottoNumber = inputView.getWinningLotto();
        List<LottoNumber> winningLotto = Lotto.getLottoNumberListWithSplitting(winningLottoNumber);
        LottoNumber bonusNumber = new LottoNumber(inputView.getBonusBall());
        this.winningLotto = new WinningLotto(bonusNumber, winningLotto);
    }

    private void printLottoResult() {
        lottoMatcher.checkAllTickets(purchasedTickets, winningLotto);
        OutputView.printWinningResult(lottoMatcher.getPrizeBoard());
        int revenue = ROICalculator.getRevenue(lottoMatcher.getPrizeBoard());
        OutputView.printReturnOnInvestment(
            ROICalculator.calculateReturnOnInvestment(revenue, money.getMoney()));
    }
}
