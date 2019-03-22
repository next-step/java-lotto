package lotto;

import lotto.domain.*;
import lotto.domain.WinningLotto;
import lotto.domain.LottoBundle;
import lotto.parser.LottoNumberParser;
import lotto.view.ConsoleInputView;
import lotto.view.ConsoleOutputView;
import lotto.vo.LottoGameResult;
import lotto.vo.Money;

import java.util.Scanner;

public class ConsoleMain {
    public static void main(String[] args) {
        LottoBundle lottoBundle;
        WinningLotto winner;

        try (Scanner scanner = new Scanner(System.in)) {
            long purchaseAmount = ConsoleInputView.inputMoney(scanner);
            lottoBundle = LottoMachine.buyLottos(new Money(purchaseAmount));

            ConsoleOutputView.printNumberOfLottos(lottoBundle);
            ConsoleOutputView.printLottos(lottoBundle);

            String winnerNumbersString = ConsoleInputView.inputWinnerNumbers(scanner);
            String bonusNumber = ConsoleInputView.inputBonusNumber(scanner);
            winner = LottoNumberParser.parse(winnerNumbersString, bonusNumber);
        }

        LottoGameResult lottoGameResult = LottoRunner.runLotto(winner, lottoBundle);
        ConsoleOutputView.printEmptyLine();
        ConsoleOutputView.printStatistics(lottoGameResult);
    }
}
