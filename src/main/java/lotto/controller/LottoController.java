package lotto.controller;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.Lottos;
import lotto.domain.lotto.Money;
import lotto.domain.lotto.WinningLotto;
import lotto.domain.winning.WinningStatistics;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.io.PrintWriter;
import java.util.Scanner;

public class LottoController {

    private static final String NUMBER_FORMAT_EXCEPTION_MESSAGE = "숫자를 입력해야 합니다.주세요.";

    private LottoController() {
    }

    public static void main(String[] args) {
        PrintWriter output = new PrintWriter(System.out, true);
        InputView inputView = new InputView(new Scanner(System.in), output);
        ResultView resultView = new ResultView(output);
        while (true) {
            if (executeAndCheckException(inputView, resultView)) break;
        }
        output.close();
    }

    private static boolean executeAndCheckException(InputView inputView, ResultView resultView) {
        try {
            execute(inputView, resultView);
            return true;
        } catch (NumberFormatException exception) {
            resultView.showErrorMessage(NUMBER_FORMAT_EXCEPTION_MESSAGE);
        } catch (Exception exception) {
            resultView.showErrorMessage(exception.getMessage());
        }
        return false;
    }

    private static void execute(InputView inputView, ResultView resultView) {
        Money money = Money.of(inputView.getMoney());
        int manualLottoCount = inputView.getManualLottoCount();
        Lottos lottos = Lottos.withMoneyAndManualLottoNumbers(money, inputView.getManualLottoNumbers(manualLottoCount));
        resultView.showLottos(lottos, manualLottoCount);
        WinningStatistics winningStatistics = lottos.getWinningStatistics(
                WinningLotto.of(Lotto.ofNumbers(inputView.getLastLottoNumbers()), LottoNumber.of(inputView.getBonusLottoNumber())));
        resultView.showResult(winningStatistics, winningStatistics.calculateYield(money));
    }
}
