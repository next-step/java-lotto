package lotto.domain;

import lotto.util.LottoListGenerator;
import lotto.view.ResultView;

public class LottoGame {
    private Lottos lottos;

    public void purchase(int ticketNumber) {
        lottos = new Lottos(LottoListGenerator.creatLottos(ticketNumber));
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
