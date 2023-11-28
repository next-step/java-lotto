package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    private final LottoGenerator lottoGenerator;

    public LottoMachine(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public Lottos createLottos(long lottoCnt) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCnt; i++) {
            lottos.add(new Lotto(lottoGenerator.createLotto(LottoNumber.allNumbers())));
        }
        return new Lottos(lottos);
    }
}
