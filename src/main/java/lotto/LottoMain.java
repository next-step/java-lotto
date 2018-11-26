package lotto;

import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.*;

public class LottoMain {
    public static void main(String[] args) {
        Money money = InputView.getPrice();
        OutputView.printAmount(money.getQuntity());

        LottoPrinter lottoPrinter = new AutoLottoPrinter();
        List<Lotto> purchaseLotto = lottoPrinter.printer(money.getQuntity());
        OutputView.printPurchaseLottos(purchaseLotto);

        WinningNumber winningNumber = InputView.getWinningNumber();

        LottoResult lottoResult = new LottoResult(winningNumber.match(purchaseLotto));
        OutputView.printLottoResult(lottoResult);
        double earning = lottoResult.computeEarning();

        OutputView.printEarningRate(money.earningRate(earning));
    }
}
