package step4;

import step4.generator.LottoGenerator;
import step4.model.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGame {
    private final Lottos lottos;
    private final Money money;

    public LottoGame(LottoGenerator generator, Money money) {
        this.lottos = generator.generate(money);
        this.money = money;
    }

    public List<Lotto> getLottos() {
        return lottos.getLottos();
    }

    public LottoResult getResult(WinningLotto winningLotto) {
        return new LottoResult(winningLotto.getResult(lottos), money);
    }
}
