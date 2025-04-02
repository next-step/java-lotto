package lotto;

import calculator.Operator;
import view.LottoNumbersParser;
import view.InputView;
import view.OutputView;

import java.util.List;

import static lotto.Lotto.LOTTO_PRICE;

public class LottoApplication {

    public static void main(String[] args) {

        Integer lottoPurchaseAmount = InputView.showLottoPurchaseAmountInput();
        Integer lottoQuantity = Operator.DIVIDE.formula.apply(lottoPurchaseAmount, LOTTO_PRICE);
        OutputView.showLottoQuantity(lottoQuantity);

        List<Lotto> lottos = LottoNumberGenerator.generateLottoNumbers(lottoQuantity);
        OutputView.showGeneratedLottoNumber(lottos);
        List<Integer> winningLotto = LottoNumbersParser.parse(InputView.showWinningLottoNumbersInput());

        Integer bonusNumber = InputView.showLottoBonusNumberInput();

        LottosResult lottosResult = new LottosResult(lottos, winningLotto, bonusNumber);
        OutputView.showLottoRankResult(lottosResult);
        OutputView.showTotalYieldRate(lottosResult.getTotalYieldRate());
    }
}
