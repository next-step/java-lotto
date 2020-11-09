package lotto;

import lotto.domain.Lotto;
import lotto.dto.WinningStatistic;
import lotto.view.View;

import java.util.List;

public class LottoGame {
    private final View view;
    private final LottoFactory lottoFactory;
    private final WinningChecker winningChecker;

    public LottoGame(View view, LottoFactory lottoFactory, WinningChecker winningChecker) {
        this.view = view;
        this.lottoFactory = lottoFactory;
        this.winningChecker = winningChecker;
    }

    public void start() {
        int amount = view.getAmount();
        List<Lotto> boughtLottos = lottoFactory.buyLottos(amount);
        view.printBoughtLottos(boughtLottos);
        if (boughtLottos.size() == 0) {
            return;
        }

        Lotto winningLotto = new Lotto(view.getWinningNumbers());
        WinningStatistic winningStatistic = winningChecker.getResult(winningLotto, boughtLottos);
        view.printWinningStatistic(winningStatistic);
    }
}
