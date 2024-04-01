package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class AutoLottoMain {
    public static void main(String[] args) {

        int amount = InputView.scanAmount();
        LottoStore lottoStore = new LottoStore();
        List<Lotto> lottos = lottoStore.buyLottos(amount);
        Lottos issuedLottos = new Lottos(lottos);
        OutputView.printBuyLottos(lottos);

        List<Integer> winNumbers = InputView.scanWinningNumbers();
        Lotto winner = new Lotto(winNumbers);
        int bonusNumber = InputView.scanBonusNumber();
        WinningLotto winningLotto = new WinningLotto(winner, bonusNumber);

        WinningStatic winningStatic = new WinningStatic(issuedLottos.winningCount(winningLotto));
        OutputView.printWinningStatic(winningStatic);
        OutputView.printReturnRate(winningStatic.returnRate(amount));
    }
}
