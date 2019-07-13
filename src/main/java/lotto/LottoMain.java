package lotto;

import java.util.Collections;
import java.util.List;

public class LottoMain {
    public static void main(String[] args) {
        int inputAmount = InputView.inputAmount();
        int manualNumberCount = InputView.inputManualNumberCount();
        Money money = new Money(inputAmount);
        List<String> inputManualNumbers = Collections.emptyList();
        if (manualNumberCount > 0) {
            inputManualNumbers = InputView.inputManualNumber(manualNumberCount);
        }

        LottoGame lottoGame = new LottoGame(new LottoGeneratorRandom(money, manualNumberCount)).addManual(inputManualNumbers);
        OutputView.outputCnt(money.countOfBuyingLotto(), manualNumberCount);
        OutputView.outputLottos(lottoGame.getLottos());

        String winningNumber = InputView.inputWinningNumber();
        int bounsNumber = InputView.inputBouseNumber();
        WinningLotto winningLotto = new WinningLotto(LottoManual.of(winningNumber), LottoNumber.of(bounsNumber));

        LottoResult lottoResult = lottoGame.result(winningLotto);
        OutputView.winningNumberPrint(lottoResult);

        Money prize = lottoResult.getPrize();
        OutputView.rateOfReturn(prize, money);

    }
}
