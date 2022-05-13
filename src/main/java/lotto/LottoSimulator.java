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
        int purchaseAmount = InputView.purchaseAmountView();
        int manualLottoCount = InputView.manualLottoCountView();
        List<LottoNumbers> manualLottoNumberValues = InputView.manualLottoNumberValuesView(manualLottoCount);

        LottoGame lottoGame = new LottoGame(new Cash(purchaseAmount), manualLottoNumberValues);
        ResultView.purchasedLottosView(PurchasedLottos.from(lottoGame));

        String lastWinningLottoNumbers = InputView.lastWinningLottoNumberView();
        int bonusNumber = InputView.bonusBallView();
        lottoGame.confirmLottos(new LottoNumbers(lastWinningLottoNumbers), LottoNumber.valueOf(bonusNumber));

        ResultView.lottosResultView(WinningStats.from(lottoGame));
    }
}
