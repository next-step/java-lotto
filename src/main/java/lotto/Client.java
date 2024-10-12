package lotto;

import lotto.domain.LottoNumbersGenerater;
import lotto.domain.RandomNumbersGenerater;
import lotto.ui.ConsoleInputView;
import lotto.ui.ConsoleResultView;
import lotto.ui.InputView;
import lotto.ui.ResultView;

public class Client {
    public static void main(String[] args) {
        InputView inputView = new ConsoleInputView();
        ResultView resultView = new ConsoleResultView();
        LottoNumbersGenerater numbersGenerater = new RandomNumbersGenerater();

        LottoApplication lottoService = new LottoApplication(inputView, resultView, numbersGenerater);
        lottoService.run();
    }
}
