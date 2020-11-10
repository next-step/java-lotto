package lotto;

import lotto.domain.Lotto;
import lotto.dto.WinningStatistic;
import lotto.service.LottoService;
import lotto.view.View;

import java.util.List;

public class LottoGame {
    private final View view;
    private final LottoService lottoService;

    public LottoGame(View view, LottoService lottoService) {
        this.view = view;
        this.lottoService = lottoService;
    }

    public void start() {
        int amount = view.getAmount();
        List<Lotto> boughtLottos = lottoService.buyLottos(amount);
        view.printBoughtLottos(boughtLottos);
        if (boughtLottos.size() == 0) {
            return;
        }

        Lotto winningLotto = new Lotto(view.getWinningNumbers());
        WinningStatistic winningStatistic = lottoService.getResult(winningLotto, boughtLottos);
        view.printWinningStatistic(winningStatistic);
    }
}
