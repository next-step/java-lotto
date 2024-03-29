package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class AutoLottoMain {
    public static void main(String[] args) {

        int amount = InputView.scanAmount();
        LottoStore lottoStore = new LottoStore();
        List<Lotto> lottos = lottoStore.buyLottos(amount);
        OutputView.printBuyLottos(lottos);

        List<Integer> winNumbers = InputView.scanWinningNumbers();
        int bonusNumber = InputView.scanBonusNumber();

        Lottos issuedLottos = new Lottos(lottos);
        Map<WinningType, Long> winningStatic = issuedLottos.winningStatistic(winNumbers, bonusNumber);
        OutputView.printWinningStatic(winningStatic);

        Revenue revenue = new Revenue(winningStatic);
        OutputView.printReturnRate(revenue.returnRate(amount));
    }
}
