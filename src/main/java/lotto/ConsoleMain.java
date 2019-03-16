package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoBundle;
import lotto.domain.LottoChecker;
import lotto.domain.LottoMachine;
import lotto.view.ConsoleInputView;
import lotto.view.ConsoleOutputView;
import lotto.vo.LottoResult;

import java.util.Scanner;

public class ConsoleMain {
    public static void main(String[] args) {
        long money;
        LottoBundle lottoBundle;
        Lotto winner;

        try (Scanner scanner = new Scanner(System.in)) {
            money = ConsoleInputView.inputMoney(scanner);
            ConsoleOutputView.printNumberOfAffordableLottos(money);

            lottoBundle = LottoMachine.buyLottos(money);
            ConsoleOutputView.printLottos(lottoBundle);

            winner = ConsoleInputView.inputWinnerNumbers(scanner);
        }

        LottoResult lottoResult = LottoChecker.getResult(winner, lottoBundle);
        ConsoleOutputView.printWinStatistics(money, lottoResult);
    }
}
