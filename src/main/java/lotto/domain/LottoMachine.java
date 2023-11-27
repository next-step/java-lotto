package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    private final RandomNumbersGenerator randomNumberGenerator;

    public LottoMachine(RandomNumbersGenerator randomNumbersGenerator) {
        this.randomNumberGenerator = randomNumbersGenerator;
    }

    public Lottos createLottos(long lottoCnt) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCnt; i++) {
            lottos.add(new Lotto(randomNumberGenerator.createRandomNumbers()));
        }
        return new Lottos(lottos);
    }
}
