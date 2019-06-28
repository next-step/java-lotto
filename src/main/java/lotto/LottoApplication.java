package lotto;

import lotto.model.Number;
import lotto.model.*;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {

    public static void main(String[] args) {

        Order order = InputView.inputOrder();
        Lottos handPickLottos = InputView.askHandPickLottoNumber(order.getHandPickCount());

        LottoStore lottoStore = new LottoStore(order, handPickLottos);
        Lottos lottos = lottoStore.buyAutoPick();

        ResultView.printBuyLottoCount(order);
        ResultView.printPickedLottoNumbers(lottos);

        LottoNumbers numbers = InputView.inputWinningNumber();
        Number bonusNumber = InputView.winningBonusNumber();
        WinningNumbers winningNumbers = new WinningNumbers(numbers, bonusNumber);

        LottoAggregator lottoAggregator = lottos.matchWinningNumber(winningNumbers);
        ResultView.printResult(lottoAggregator);
    }
}
