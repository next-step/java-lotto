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
import java.util.function.Supplier;

public class LottoController {

    private static final String NUMBER_FORMAT_EXCEPTION_MESSAGE = "숫자를 입력해야 합니다.주세요.";

    private LottoController() {
    }

    public static void main(String[] args) {
        PrintWriter output = new PrintWriter(System.out, true);
        InputView inputView = new InputView(new Scanner(System.in), output);
        ResultView resultView = new ResultView(output);
        buyLottAndCalculateYield(inputView, resultView);
        output.close();
    }

    private static void buyLottAndCalculateYield(InputView inputView, ResultView resultView) {
        Money money = input(() -> Money.of(inputView.getMoney()), resultView);
        int manualLottoCount = input(inputView::getManualLottoCount, resultView);
        Lottos lottos = Lottos.buy(money, input(() -> inputView.getManualLottoNumbers(manualLottoCount), resultView));
        resultView.showLottos(lottos, manualLottoCount);
        WinningStatistics winningStatistics = lottos.getWinningStatistics(
                WinningLotto.of(Lotto.ofNumbers(inputView.getLastLottoNumbers()), LottoNumber.of(input(inputView::getBonusLottoNumber, resultView))));
        resultView.showResult(winningStatistics, winningStatistics.calculateYield(money));
    }

    private static <T> T input(Supplier<T> inputValueSupplier, ResultView resultView) {
        try {
            return inputValueSupplier.get();
        } catch (NumberFormatException exception) {
            resultView.showErrorMessage(NUMBER_FORMAT_EXCEPTION_MESSAGE);
            return input(inputValueSupplier, resultView);
        } catch (Exception e) {
            resultView.showErrorMessage(e.getMessage());
            return input(inputValueSupplier, resultView);
        }
    }
}
