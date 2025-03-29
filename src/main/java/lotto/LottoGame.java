package lotto;

import lotto.domain.LottoMachine;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumberMatcher;
import lotto.domain.LottoWinningRecord;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoGame {

    public static void main(String[] args) {
        long amount = InputView.purchaseAmount();
        LottoMachine machine = new LottoMachine();
        List<LottoNumber> purchasedLottos = machine.buy(amount);
        ResultView.showPurchasedLottos(purchasedLottos);

        String lastWinningLottoNumbers = InputView.inputLastWinningLottoNumbers();

        LottoNumberMatcher matcher = new LottoNumberMatcher(purchasedLottos, LottoNumber.toLottoNumber(lastWinningLottoNumbers));
        LottoWinningRecord winningRecord = matcher.result();
        ResultView.showLottoWinningResult(winningRecord, purchasedLottos.size());
    }
}
