package lotto;

import lotto.model.*;
import lotto.model.Number;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoAplication {

    public static void main(String[] args) {

        Order order = InputView.inputOrder();
        Lottos handPickLottos = InputView.askHandPickLottoNumber(order.getHandPickCount());

        LottoStore lottoStore = new LottoStore(order, handPickLottos);
        Lottos lottos = lottoStore.buyAutoPick();

        ResultView.printBuyLottoCount(order);
        ResultView.printPickedLottoNumbers(lottos);

        LottoResultMatcher lottoResultMatcher = new LottoResultMatcher(lottos);

        List<Number> numbers = InputView.inputWinningNumber();
        Number bonusNumber = InputView.winningBonusNumber();
        WinningNumbers winningNumbers = new WinningNumbers(numbers, bonusNumber);

        LottoAggregator lottoAggregator = lottoResultMatcher.matching(winningNumbers);
        ResultView.printResult(lottoAggregator);
    }
}
