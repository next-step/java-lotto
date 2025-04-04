package lotto;

import calculator.Operator;
import view.LottoNumbersParser;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static lotto.Lotto.LOTTO_PRICE;

public class LottoApplication {

    public static void main(String[] args) {


        int lottoPurchaseAmount = InputView.showLottoPurchaseAmountInput();
        int totalLottoCount = Operator.DIVIDE.formula.apply(lottoPurchaseAmount, LOTTO_PRICE);

        int manualLottoCount = InputView.showManualLottoCountInput();
        List<Lotto> lottos = new ArrayList<>(InputView.showManualLottoNumbersInput(manualLottoCount));

        int autoLottoCount = totalLottoCount - manualLottoCount;
        lottos.addAll(LottoNumberGenerator.generateLottoNumbers(autoLottoCount));
        OutputView.showTotalLottoCount(manualLottoCount, autoLottoCount);
        OutputView.showGeneratedLottoNumber(lottos);

        List<Integer> winningLotto = LottoNumbersParser.parse(InputView.showWinningLottoNumbersInput());
        Integer bonusNumber = InputView.showLottoBonusNumberInput();

        LottosResult lottosResult = new LottosResult(lottos, winningLotto, bonusNumber);
        OutputView.showLottoRankResult(lottosResult);
        OutputView.showTotalYieldRate(lottosResult.getTotalYieldRate());
    }
}
