package step2step3;

import step2step3.io.ConsoleInputView;
import step2step3.io.ConsoleOutputDevice;
import step2step3.io.ConsoleOutputView;
import step2step3.lottoGame.LottoGame;
import step2step3.lotto.LottoTickets;
import step2step3.lotto.NumbersGenerator;
import step2step3.lotto.OutputDevice;
import step2step3.randomNumbers.RandomNumbersGenerator;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        ConsoleInputView consoleInputView = new ConsoleInputView();
        ConsoleOutputView outputView = new ConsoleOutputView();
        NumbersGenerator numbersGenerator = new RandomNumbersGenerator();
        OutputDevice outputDevice = new ConsoleOutputDevice();

        LottoGame lottoGame = new LottoGame(outputDevice, outputView, consoleInputView, numbersGenerator);
        LottoTickets lottoTickets = lottoGame.purchasedLotteries();

        lottoGame.printLottoTicketsNumbers(lottoTickets);
        lottoGame.winningStatistics(lottoTickets);
    }

}
