package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class AutoLottoMain {
    public static void main(String[] args) {

        int amount = InputView.scanAmount();
        int manualLottoCount = InputView.scanManualCount();
        List<Lotto> manualLottos = InputView.scanManualNumbers(manualLottoCount);

        LottoStore lottoStore = new LottoStore();
        List<Lotto> lottos = lottoStore.buyLottos(amount);
        Lottos issuedLottos = new Lottos(lottos);
        OutputView.printBuyLottos(lottos);

        List<Integer> winNumbers = InputView.scanWinningNumbers();
        Lotto winner = new Lotto(winNumbers);
        int bonusNumber = InputView.scanBonusNumber();
        WinningLotto winningLotto = new WinningLotto(winner, bonusNumber);

        LottoResult lottoResult = issuedLottos.winningResult(winningLotto);
        OutputView.printWinningStatic(lottoResult);
        OutputView.printReturnRate(lottoResult.returnRate(amount));
    }
}
