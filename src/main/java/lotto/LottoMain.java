package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoMain {
    public static void main(String[] args) {
        int amount = InputView.scanAmount();
        Lottos manualLottos = InputView.scanManualNumbers(InputView.scanManualCount());

        LottoStore lottoStore = new LottoStore();
        List<Lotto> lottos = lottoStore.buyLottos(amount, manualLottos);
        Lottos issuedLottos = new Lottos(lottos);
        OutputView.printBuyLottos(lottos);

        Lotto winner = new Lotto(InputView.scanWinningNumbers());
        WinningLotto winningLotto = new WinningLotto(winner, InputView.scanBonusNumber());

        LottoResult lottoResult = issuedLottos.winningResult(winningLotto);
        OutputView.printWinningStatic(lottoResult);
        OutputView.printReturnRate(lottoResult.returnRate(amount));
    }
}
