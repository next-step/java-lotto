package step2_lotto;

import step2_lotto.domain.Lotto;
import step2_lotto.domain.LottoStore;
import step2_lotto.domain.Winner;
import step2_lotto.domain.WinningStatic;
import step2_lotto.view.InputView;
import step2_lotto.view.OutputView;

import java.util.List;

public class AutoLottoMain {
    public static void main(String[] args) {

        int amount = InputView.scanAmount();
        LottoStore lottoStore = new LottoStore();
        List<Lotto> lottos = lottoStore.buyLottos(amount);
        OutputView.printBuyLottos(lottos);

        List<Integer> winNumbers = InputView.scanWinningNumbers();
        Winner winner = new Winner(winNumbers);
        WinningStatic winningStatic = new WinningStatic();
        
        for (Lotto lotto: lottos) {
            long hitCount = winner.hitCount(lotto);
            winningStatic.countHitNumber(hitCount);
        }

        winningStatic.calculateTotalRevenue();
        OutputView.printWinningStatic(winningStatic);
        OutputView.printReturnRate(winningStatic.returnRate(amount));
    }
}
