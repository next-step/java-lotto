package lotto;

import lotto.domain.LottoMachine;
import lotto.domain.LottoNumbersWrapper;
import lotto.domain.LottoWrapper;
import lotto.domain.Result;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoApplication {
    public static void main(String[] args) {
        int purchaseAmount = InputView.inputPurchaseAmount();
        int passiveLottoCount = InputView.inputPassiveLottoCount();
        List<LottoNumbersWrapper> numbersCollection = InputView.inputPassiveLottoNumbers(passiveLottoCount);

        LottoMachine lottoMachine = new LottoMachine();
        LottoWrapper lottoWrapper = lottoMachine.buyLotto(purchaseAmount, passiveLottoCount, numbersCollection);

        ResultView.printLottoState(lottoWrapper, passiveLottoCount);

        LottoNumbersWrapper lastWeeksCollectNumbers = InputView.inputLastWeeksCollectNumbers();

        ResultView.printResult(new Result(lottoWrapper, lastWeeksCollectNumbers, InputView.inputBonusNumber()));
    }
}