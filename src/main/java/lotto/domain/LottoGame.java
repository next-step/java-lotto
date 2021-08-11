package lotto.domain;

import lotto.util.LottoListGenerator;

public class LottoGame {
    private Lottos lottos;

    public Lottos purchase(int ticketNumber) {
        lottos = new Lottos(LottoListGenerator.creatLottos(ticketNumber));
        return lottos;
    }

    public void drawLotto(Lotto winnerLotto) {
        lottos.drawLottos(winnerLotto);
    }

    public long countWinners(Award award) {
        return lottos.countWinners(award);
    }

    public Lottos getLottos() {
        return lottos;
    }
}
