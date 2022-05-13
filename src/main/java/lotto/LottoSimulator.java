package lotto;

import lotto.domain.LottoGame;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.dto.result.PurchasedLottos;
import lotto.dto.result.WinningStats;
import lotto.util.SplitUtil;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoSimulator {

    public static void main(String[] args) {
        int purchaseAmount = InputView.purchaseAmountView();
        int manualLottoCount = InputView.manualLottoCountView();
        List<String> manualLottoNumberValues = InputView.manualLottoNumberValuesView(manualLottoCount);

        LottoGame lottoGame = new LottoGame(purchaseAmount, manualLottoNumberValues);
        ResultView.purchasedLottosView(PurchasedLottos.from(lottoGame));

        String lastWinningLottoNumbers = InputView.lastWinningLottoNumberView();
        int bonusNumber = InputView.bonusBallView();
        lottoGame.confirmLottos(new LottoNumbers(lastWinningLottoNumbers), LottoNumber.valueOf(bonusNumber));

        ResultView.lottosResultView(WinningStats.from(lottoGame));
    }
}
