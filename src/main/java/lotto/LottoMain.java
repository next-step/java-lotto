package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoStore;
import lotto.domain.Rank;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoMain {

    public static void main(String[] args) {
        LottoStore store = new LottoStore();
        List<Lotto> lottos = store.buy(InputView.readAmount());
        OutputView.renderingLottos(lottos);

        List<Rank> result = new ArrayList<>();
        Lotto winningLotto = Lotto.from(InputView.readWinningNumber());
        for (Lotto lotto : lottos) {
            result.add(store.check(lotto, winningLotto));
        }
        OutputView.renderingWinningStatistics(result);
    }
}
