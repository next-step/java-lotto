package lotto.domain;

import lotto.util.LottoListGenerator;

import java.util.Set;

public class LottoGame {
    private Lottos lottos;

    public Lottos purchase(int ticketNumber) {
        lottos = new Lottos(LottoListGenerator.creatLottos(ticketNumber));
        return lottos;
    }

    public void drawLotto(Set<LottoNumber> winnerNumbers) {
        lottos.drawLottos(winnerNumbers);
    }

    public long countWinners(Award award) {
        return lottos.countWinners(award);
    }

    public Lottos getLottos() {
        return lottos;
    }
}
