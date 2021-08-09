package lotto.domain;

import java.util.List;
import java.util.Set;

public class Lottos {
    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int size() {
        return lottos.size();
    }

    public void drawLottos(Set<LottoNumber> winnerNumbers) {
        for (Lotto lotto : lottos) {
            lotto.drawLotto(winnerNumbers);
        }
    }

    public long countWinners(Award award) {
        return lottos.stream().filter(lotto -> lotto.isWinner(award)).count();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

}
