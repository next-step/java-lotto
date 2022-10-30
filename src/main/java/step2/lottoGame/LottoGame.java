package step2.lottoGame;

import step2.io.ConsoleInputView;
import step2.io.ConsoleOutputView;
import step2.lotto.*;
import step2.randomNumbers.InfusedNumbersGenerator;

import java.io.IOException;

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
        InfusedNumbersGenerator infusedNumbersGenerator = new InfusedNumbersGenerator(consoleInputView.winningNumbers());
        LottoTicket winningLottoTicket = LottoTicket.from(infusedNumbersGenerator);

        printMatchIndicator(lottoTickets, winningLottoTicket);
        printYield(lottoTickets, winningLottoTicket);
    }

    private void printMatchIndicator(LottoTickets lottoTickets, LottoTicket winningLottoTicket) {
        MatchIndicatorCalculator matchIndicatorCalculator = lottoTickets.matchIndicatorCalculator(winningLottoTicket);
        consoleOutputView.printMatchIndicator(matchIndicatorCalculator.matchIndicators());
    }

    private void printYield(LottoTickets lottoTickets, LottoTicket winningLottoTicket) {
        YieldCalculator yieldCalculator = lottoTickets.yieldCalculator(winningLottoTicket);
        consoleOutputView.printYield(yieldCalculator.yield());
    }

}
