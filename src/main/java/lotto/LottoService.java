package lotto;

import java.util.List;

public class LottoService {

    public LottoService() {
    }

    public Lottos buyLotto(Money money) {
        return new Lottos(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6))));
    }
}
