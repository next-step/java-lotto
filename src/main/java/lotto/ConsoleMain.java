package lotto;

import lotto.domain.*;
import lotto.domain.WinningLotto;
import lotto.domain.LottoBundle;
import lotto.parser.LottoNumberParser;
import lotto.view.ConsoleInputView;
import lotto.view.ConsoleOutputView;
import lotto.vo.LottoGameResult;
import lotto.vo.Money;

import java.util.List;
import java.util.Scanner;

public class ConsoleMain {
    public static void main(String[] args) {
        LottoBundle lottoBundle;
        WinningLotto winner;

        try (Scanner scanner = new Scanner(System.in)) {
            long purchaseAmount = ConsoleInputView.inputMoney(scanner);
            ConsoleOutputView.printEmptyLine();

            long manualTimes = ConsoleInputView.inputManualTimes(scanner);
            ConsoleOutputView.printEmptyLine();

            List<String> manualLottos = ConsoleInputView.inputManualLottos(scanner, manualTimes);
            LottoBundle manualLottoBundle = LottoNumberParser.parseLottoBundle(manualLottos);
            ConsoleOutputView.printEmptyLine();

            lottoBundle = LottoMachine.buyLottos(manualLottoBundle, new Money(purchaseAmount));
            ConsoleOutputView.printNumberOfLottos(lottoBundle);
            ConsoleOutputView.printLottos(lottoBundle);

            String winnerNumbersString = ConsoleInputView.inputWinnerNumbers(scanner);
            String bonusNumber = ConsoleInputView.inputBonusNumber(scanner);
            winner = LottoNumberParser.parseWinningLotto(winnerNumbersString, bonusNumber);
            ConsoleOutputView.printEmptyLine();
        }

        LottoGameResult lottoGameResult = LottoRunner.runLotto(winner, lottoBundle);
        ConsoleOutputView.printStatistics(lottoGameResult);
    }
}
