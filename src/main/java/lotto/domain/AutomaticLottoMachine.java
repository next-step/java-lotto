package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class AutomaticLottoMachine {

    private final RandomLottoGenerator randomLottoGenerator;

    public AutomaticLottoMachine(RandomLottoGenerator randomLottoGenerator) {
        this.randomLottoGenerator = randomLottoGenerator;
    }

    public Lottos createLottos(long lottoCnt) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCnt; i++) {
            lottos.add(createRandomLottoNumbers());
        }
        return new Lottos(lottos);
    }

    private Lotto createRandomLottoNumbers() {
        return new Lotto(randomLottoGenerator.createLotto(LottoNumber.allNumbers()));
    }
}
