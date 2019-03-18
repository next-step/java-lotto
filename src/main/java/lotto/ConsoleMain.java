package lotto;

import lotto.domain.*;
import lotto.domain.ticket.Lotto;
import lotto.domain.ticket.LottoBundle;
import lotto.parser.LottoNumberParser;
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

            lottoBundle = LottoMachine.buyLottos(money);
            ConsoleOutputView.printNumberOfLottos(lottoBundle.getLottos().size());
            ConsoleOutputView.printLottos(lottoBundle);

            String winnerNumbersString = ConsoleInputView.inputWinnerNumbers(scanner);
            int bonusNumber = ConsoleInputView.inputBonusNumber(scanner);
            winner = LottoNumberParser.parse(winnerNumbersString, bonusNumber);
        }

        LottoResult lottoResult = LottoRunner.runLotto(winner, lottoBundle);
        ConsoleOutputView.printWinStatistics(lottoResult);
    }
}
