package lotto;

import lotto.domain.Cash;
import lotto.domain.LottoGame;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.dto.result.PurchasedLottos;
import lotto.dto.result.WinningStats;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoSimulator {

    public static void main(String[] args) {
        Cash purchaseAmount = InputView.purchaseAmountView();
        int manualLottoCount = InputView.manualLottoCountView(purchaseAmount.totalLottoCount());
        List<LottoNumbers> manualLottoNumberValues = InputView.manualLottoNumbersView(manualLottoCount);

        LottoGame lottoGame = new LottoGame(purchaseAmount, manualLottoNumberValues);
        ResultView.purchasedLottosView(PurchasedLottos.from(lottoGame));

        LottoNumbers lastWinningLottoNumbers = InputView.lastWinningLottoNumberView();
        LottoNumber bonusNumber = InputView.bonusBallView(lastWinningLottoNumbers);
        lottoGame.confirmLottos(lastWinningLottoNumbers, bonusNumber);

        ResultView.lottosResultView(WinningStats.from(lottoGame));
    }
}
