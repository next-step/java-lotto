package lotto;

import lotto.domain.*;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Money money = LottoInputView.askBuyAmount();
        int maxBuyCount = money.buyCount(Lotto.PRICE);

        int manualLottoCount = LottoInputView.askManualLottoCount(maxBuyCount);
        List<String> manualLottoNumbers = LottoInputView.askManualLottoNumbers(manualLottoCount);
        List<Lotto> manualLottos = LottoGenerator.manualGenerateLottos(manualLottoNumbers);

        int autoLottoCount = maxBuyCount - manualLottoCount;
        List<Lotto> autoLottos = LottoGenerator.autoGenerateLottos(autoLottoCount);

        Lottos lottos = new Lottos(manualLottos, autoLottos);
        LottoOutputView.printLottos(lottos);

        String stringNumbers = LottoInputView.askLastWinnerNumbers();
        int bonusNumber = LottoInputView.askLastBonusNumber();
        WinnerNumbers winnerNumbers = new WinnerNumbers(stringNumbers, bonusNumber);

        LottoResults lottoResults = winnerNumbers.matchLottos(lottos);
        LottoOutputView.printLottoResults(lottoResults);

        Money reward = lottoResults.totalReward();
        double winningRatio = reward.ratio(money);
        LottoOutputView.printWinningRatio(winningRatio);
    }
}
