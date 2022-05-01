package lotto.domain;

import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int count() {
        return lottos.size();
    }

    public void confirmAll(LottoNumbers winningNumbers) {
        for (Lotto lotto : lottos) {
            lotto.confirm(winningNumbers.toList());
        }
    }

    public List<Lotto> toList() {
        return lottos;
    }
}
