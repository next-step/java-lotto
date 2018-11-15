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
        LottoComparator lottoComparator = new LottoComparator();
        lottoComparator.comparate(purchaseLotto, winningNumber.getWinningNumbers());
        OutputView.printCompareResult(lottoComparator);

        double earing = ComputeEarningsRate.computeEarning(lottoComparator.getWinnings(), 0.0);
        double eaningRate = ComputeEarningsRate.computeEarningRate(earing, money.getPrice());
        OutputView.printEaningRate(eaningRate);
    }
}
