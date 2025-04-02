package lotto;

import lotto.domain.*;
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
        String lastBonusLottoNumber = InputView.inputLastBonusLottoNumbers();

        WinningLottoNumbers winningLottoNumbers = WinningLottoNumbers.toLottoNumbers(lastWinningLottoNumbers, lastBonusLottoNumber);
        LottoNumberMatcher matcher = new LottoNumberMatcher(purchasedLottos, winningLottoNumbers);
        LottoWinningRecord winningRecord = matcher.result();
        ResultView.showLottoWinningResult(winningRecord, purchasedLottos.size());
    }
}
