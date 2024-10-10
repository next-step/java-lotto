package lotto.step2;

import lotto.step2.domain.LottoNumbersGenerater;
import lotto.step2.domain.RandomNumbersGenerater;
import lotto.step2.ui.ConsoleInputView;
import lotto.step2.ui.ConsoleResultView;
import lotto.step2.ui.InputView;
import lotto.step2.ui.ResultView;

public class Client {
    public static void main(String[] args) {
        InputView inputView = new ConsoleInputView();
        ResultView resultView = new ConsoleResultView();
        LottoNumbersGenerater numbersGenerater = new RandomNumbersGenerater();

        LottoApplication lottoService = new LottoApplication(inputView, resultView, numbersGenerater);
        lottoService.run();
    }
}
