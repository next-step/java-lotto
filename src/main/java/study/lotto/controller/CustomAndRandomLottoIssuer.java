package study.lotto.controller;

import study.lotto.domain.Lotto;
import study.lotto.domain.LottoIssuer;
import study.lotto.domain.Lottos;

import java.util.Optional;

public class CustomAndRandomLottoIssuer implements LottoIssuer {
    private int index = 0;
    private RandomLottoIssuer randomLottoIssuer;
    private Lottos lottos;

    CustomAndRandomLottoIssuer(Lottos lottos) {
        this.lottos = Lottos.valueOf(Optional.ofNullable(lottos));
        randomLottoIssuer = new RandomLottoIssuer();
    }

    @Override public Lotto issue() {
        if (index < lottos.size()) {
            return lottos.get(index++);
        }
        return randomLottoIssuer.issue();
    }
}
