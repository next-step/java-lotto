package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    private final RandomLottoGenerator randomLottoGenerator;

    public LottoMachine(RandomLottoGenerator randomLottoGenerator) {
        this.randomLottoGenerator = randomLottoGenerator;
    }

    public Lottos createLottos(long lottoCnt) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCnt; i++) {
            lottos.add(new Lotto(randomLottoGenerator.createLotto(LottoNumber.allNumbers())));
        }
        return new Lottos(lottos);
    }
}
