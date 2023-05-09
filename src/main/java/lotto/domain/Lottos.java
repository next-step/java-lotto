package lotto.domain;

import java.util.List;

public class Lottos {

    private List<LottoGame> lottoGames;

    public Lottos(List<LottoGame> lottoGames) {
        this.lottoGames = lottoGames;
    }

    public List<LottoGame> getLottos() {
        return this.lottoGames;
    }
}
