package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private List<Lotto> lottos;

    public Lottos(int countOfLotto, LottoNumbers numbers) {
        lottos = new ArrayList<>();
        for (int i = 0; i < countOfLotto; i++) {
            lottos.add(new Lotto(numbers));
        }
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }
}
