package AutoLotto;

import AutoLotto.model.Lottos;
import AutoLotto.model.RandomLottoGeneratorStrategy;
import AutoLotto.view.InputView;
import AutoLotto.view.OutputView;

public class AutoLotto {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        int chances = inputView.inputPurchase();
        Lottos lottos = new Lottos(chances, new RandomLottoGeneratorStrategy());
        outputView.outputPurchasedLottos(lottos, chances);
    }

}
