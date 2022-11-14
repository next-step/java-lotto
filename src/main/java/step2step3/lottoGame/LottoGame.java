package step2step3.lottoGame;

import step2step3.io.ConsoleInputView;
import step2step3.io.ConsoleOutputView;
import step2step3.lotto.LottoTickets;
import step2step3.lotto.LottoTicketsFactory;
import step2step3.lotto.MatchIndicatorCalculator;
import step2step3.lotto.YieldCalculator;
import step2step3.lotto.lottoNumber.NumbersGenerator;
import step2step3.lotto.lottoTicket.LottoTicket;
import step2step3.lotto.lottoTicket.WinningLotto;
import step2step3.randomNumbers.InfusedNumbersGenerator;

import java.io.IOException;

public class LottoGame {

    private final ConsoleOutputView consoleOutputView;
    private final ConsoleInputView consoleInputView;
    private final NumbersGenerator numbersGenerator;

    public LottoGame(ConsoleOutputView consoleOutputView, ConsoleInputView consoleInputView, NumbersGenerator numbersGenerator) {
        this.consoleOutputView = consoleOutputView;
        this.consoleInputView = consoleInputView;
        this.numbersGenerator = numbersGenerator;
    }

    public LottoTickets purchasedLotteries() throws IOException {
        return lottoTickets(consoleInputView.purchaseAmount());
    }

    private LottoTickets lottoTickets(int purchaseAmount) {
        LottoTickets lottoTickets = new LottoTicketsFactory(purchaseAmount, numbersGenerator).lottoTickets();
        consoleOutputView.printNumberOfPurchases(lottoTickets);

        return lottoTickets;
    }

    public void printLottoTicketsNumbers(LottoTickets lottoTickets) {
        consoleOutputView.printLottoTickets(lottoTickets);
    }

    public void winningStatistics(LottoTickets lottoTickets) throws IOException {
        LottoTicket winningLottoTicket = winningLottoTicket();
        int bonusNumber = consoleInputView.bonusNumber();

        WinningLotto winningLotto = new WinningLotto(bonusNumber, winningLottoTicket);
        printMatchIndicator(lottoTickets, winningLotto);
        printYield(lottoTickets, winningLotto);
    }

    private LottoTicket winningLottoTicket() throws IOException {
        InfusedNumbersGenerator infusedNumbersGenerator = new InfusedNumbersGenerator(consoleInputView.winningNumbers());
        return LottoTicket.from(infusedNumbersGenerator);
    }

    private void printMatchIndicator(LottoTickets lottoTickets, WinningLotto winningLotto) {
        MatchIndicatorCalculator matchIndicatorCalculator = lottoTickets.matchIndicatorCalculator(winningLotto);
        consoleOutputView.printMatchIndicator(matchIndicatorCalculator.matchIndicators());
    }

    private void printYield(LottoTickets lottoTickets, WinningLotto winningLotto) {
        YieldCalculator yieldCalculator = lottoTickets.yieldCalculator(winningLotto);
        consoleOutputView.printYield(yieldCalculator.yield());
    }

}
