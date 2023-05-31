package lotto;

import lotto.domain.*;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        int amount = LottoInputView.askBuyAmount();
        Money money = new Money(amount);
        int maxBuyCount = money.buyCount(Lotto.PRICE);
        int manualLottoCount = LottoInputView.askManualLottoCount(maxBuyCount);
        int autoLottoCount = maxBuyCount - manualLottoCount;

        List<String> manualLottoNumbers = LottoInputView.askManualLottoNumbers(manualLottoCount);
        List<Lotto> manualLottos = LottoGenerator.manualGenerateLottos(manualLottoNumbers);
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
