package step2step3.lottoGame;

import step2step3.io.ConsoleInputView;
import step2step3.io.ConsoleOutputView;
import step2step3.lotto.*;
import step2step3.lotto.lottoNumber.NumbersGenerator;
import step2step3.lotto.lottoTicket.LottoTicket;
import step2step3.lotto.lottoTicket.OutputDevice;
import step2step3.lotto.lottoTicket.WinningLottoInformation;
import step2step3.randomNumbers.InfusedNumbersGenerator;

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
        LottoTicket lottoTicket = lottoTicket();
        int bonusNumber = consoleInputView.bonusNumber();

        WinningLottoInformation winningLottoInformation = new WinningLottoInformation(bonusNumber, lottoTicket);
        printMatchIndicator(lottoTickets, winningLottoInformation);
        printYield(lottoTickets, winningLottoInformation);
    }

    private LottoTicket lottoTicket() throws IOException {
        InfusedNumbersGenerator infusedNumbersGenerator = new InfusedNumbersGenerator(consoleInputView.winningNumbers());
        return LottoTicket.from(infusedNumbersGenerator);
    }

    private void printMatchIndicator(LottoTickets lottoTickets, WinningLottoInformation winningLottoInformation) {
        MatchIndicatorCalculator matchIndicatorCalculator = lottoTickets.matchIndicatorCalculator(winningLottoInformation);
        consoleOutputView.printMatchIndicator(matchIndicatorCalculator.matchIndicators());
    }

    private void printYield(LottoTickets lottoTickets, WinningLottoInformation winningLottoInformation) {
        YieldCalculator yieldCalculator = lottoTickets.yieldCalculator(winningLottoInformation);
        consoleOutputView.printYield(yieldCalculator.yield());
    }

}
