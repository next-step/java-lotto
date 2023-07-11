package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoService {

    public LottoService() {
    }

    public Lottos buyLotto(Money money) {
        long countLotto = money.countLotto();
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < countLotto; i++) {
            Lotto lotto = RandomGenerator.generateLotto();
            lottos.add(lotto);
        }
        return new Lottos(lottos);
    }
}
