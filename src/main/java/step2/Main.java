package step2;

import step2.io.ConsoleInputView;
import step2.io.ConsoleOutputDevice;
import step2.io.ConsoleOutputView;
import step2.lottoGame.LottoGame;
import step2.lotto.LottoTickets;
import step2.lotto.NumbersGenerator;
import step2.lotto.OutputDevice;
import step2.randomNumbers.RandomNumbersGenerator;

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
