package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.LottoMachine.PRICE_OF_LOTTO;

public class LottoGame {
    public static void main(String[] args) {
        Money money = InputView.purchaseAmount();

        int manualPurchaseLottoCount = InputView.inputManualPurchaseCount();
        List<String> manualLottoNumberInputs = InputView.inputManualLottoNumbers(manualPurchaseLottoCount);

        LottoMachine machine = new LottoMachine();
        Lottos lottos = machine.buy(money, manualLottoNumberInputs);
        ResultView.showPurchasedLottos(lottos);

        String lastWinningLottoNumbers = InputView.inputLastWinningLottoNumbers();
        String lastBonusLottoNumber = InputView.inputLastBonusLottoNumbers();

        WinningLottoNumbers winningLottoNumbers = WinningLottoNumbers.toLottoNumbers(lastWinningLottoNumbers, lastBonusLottoNumber);
        LottoWinningRecord winningRecord = new LottoWinningRecord();
        winningRecord.match(winningLottoNumbers, lottos);
        ResultView.showLottoWinningResult(winningRecord, lottos.size());
    }
}
