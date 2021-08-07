package lotto.domain;

import lotto.strategy.ListSortOrMixStrategy;
import lotto.view.ResultView;

public class LottoGame {
    private Lottos lottos;

    public void purchase(int ticketNumber, ListSortOrMixStrategy listSortOrMixStrategy) {
        lottos = new Lottos(ticketNumber, listSortOrMixStrategy);
        ResultView.printPurchaseLottos(lottos);
    }

    public void drawLotto(LottoNumbers winnerNumbers) {
        lottos.drawLottos(winnerNumbers);
    }

    public long countWinners(Award award) {
        return lottos.countWinners(award);
    }

    public Lottos getLottos() {
        return lottos;
    }
}
