package step2.lottoGame;

import step2.lottoGame.dto.RankValues;
import step2.io.ConsoleInputView;
import step2.io.ConsoleOutputView;
import step2.lotto.*;

import java.io.IOException;
import java.util.Set;

public class LottoGame {

    private final OutputDevice outputDevice;

    private final ConsoleOutputView consoleOutputView;
    private final ConsoleInputView consoleInputView;
    private final NumbersGenerator numbersGenerator;

    public LottoGame(OutputDevice outputDevice, ConsoleOutputView consoleOutputView, ConsoleInputView consoleInputView, NumbersGenerator numbersGenerator) {
        this.outputDevice = outputDevice;
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
        lottoTickets.printNumbers(outputDevice);
    }


    public void winningStatistics(LottoTickets lottoTickets) throws IOException {
        Set<Integer> winningNumbers = consoleInputView.winningNumbers();
        printMatchIndicator(lottoTickets, winningNumbers);
        printYield(lottoTickets, winningNumbers);
    }

    private void printMatchIndicator(LottoTickets lottoTickets, Set<Integer> winningNumbers) {
        MatchIndicatorCalculator matchIndicatorCalculator = lottoTickets.matchIndicatorCalculator(winningNumbers);
        consoleOutputView.printMatchIndicator(new RankValues(matchIndicatorCalculator.matchIndicators()));
    }

    private void printYield(LottoTickets lottoTickets, Set<Integer> winningNumbers) {
        YieldCalculator yieldCalculator = lottoTickets.yieldCalculator(winningNumbers);
        consoleOutputView.printYield(yieldCalculator.yield());
    }

}
