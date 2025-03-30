package lotto;

import lotto.domain.LottoMachine;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoNumberMatcher;
import lotto.domain.LottoWinningRecord;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoGame {

    public static void main(String[] args) {
        long amount = InputView.purchaseAmount();
        LottoMachine machine = new LottoMachine();
        List<LottoNumbers> purchasedLottos = machine.buy(amount);
        ResultView.showPurchasedLottos(purchasedLottos);

        String lastWinningLottoNumbers = InputView.inputLastWinningLottoNumbers();

        LottoNumberMatcher matcher = new LottoNumberMatcher(purchasedLottos, LottoNumbers.toLottoNumber(lastWinningLottoNumbers));
        LottoWinningRecord winningRecord = matcher.result();
        ResultView.showLottoWinningResult(winningRecord, purchasedLottos.size());
    }
}
