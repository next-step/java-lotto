package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.LottoMachine.PRICE_OF_LOTTO;

public class LottoGame {
    public static void main(String[] args) {
        long amount = InputView.purchaseAmount();

        int manualPurchaseLottoCount = InputView.inputManualPurchaseCount();
        if (manualPurchaseLottoCount * PRICE_OF_LOTTO > amount) {
            throw new IllegalArgumentException("수동 구매 가격이 구입금액보다 클 수 없습니다.");
        }

        List<String> manualLottoNumberInputs = new ArrayList<>();
        if (manualPurchaseLottoCount > 0) {
            manualLottoNumberInputs = InputView.inputManualLottoNumbers(manualPurchaseLottoCount);
        }

        LottoMachine machine = new LottoMachine();
        Lottos lottos = machine.buy(amount, manualLottoNumberInputs);
        ResultView.showPurchasedLottos(lottos);

        String lastWinningLottoNumbers = InputView.inputLastWinningLottoNumbers();
        String lastBonusLottoNumber = InputView.inputLastBonusLottoNumbers();

        WinningLottoNumbers winningLottoNumbers = WinningLottoNumbers.toLottoNumbers(lastWinningLottoNumbers, lastBonusLottoNumber);
        LottoWinningRecord winningRecord = lottos.match(winningLottoNumbers);
        ResultView.showLottoWinningResult(winningRecord, lottos.size());
    }
}
