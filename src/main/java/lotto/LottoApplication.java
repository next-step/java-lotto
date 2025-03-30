package lotto;

import calculator.Operator;
import view.InputView;
import view.OutputView;

import java.util.List;

public class LottoApplication {

    public static final int LOTTO_PRICE = 1000;

    public static void main(String[] args) {

        Integer lottoPurchaseAmount = InputView.showLottoPurchaseAmountInput();
        Integer lottoQuantity = Operator.DIVIDE.formula.apply(lottoPurchaseAmount, LOTTO_PRICE);
        OutputView.showLottoQuantity(lottoQuantity);

        List<Lotto> lottos = LottoNumberGenerator.generateLottoNumbers(lottoQuantity);
        List<Integer> winningLotto = LottoNumbersParser.parse(InputView.showWinningLottoNumbersInput());

        LottosResult lottosResult = new LottosResult(lottos, winningLotto);
        OutputView.showLottoMatchResult(lottosResult);
        OutputView.showTotalYieldRate(lottosResult.getTotalYieldRate());
    }
}
