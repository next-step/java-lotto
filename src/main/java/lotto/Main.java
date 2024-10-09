package lotto;

import lotto.view.InputView;
import lotto.view.OutputView;

public class Main {

    public static void main(String[] args) {
        int money = InputView.inputAmount();

        LottoMachine lottoMachine = new LottoMachine(new LottoNumbers(1, 45));
        int lottoCount = lottoMachine.lottoCount(money);
        OutputView.lottoCount(lottoCount);

        for (int i = 0; i < lottoCount; i++) {
            OutputView.lottoView(lottoMachine.generateLotto());
        }
    }
}
