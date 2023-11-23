package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    private final RandomNumbersGenerator randomNumberGenerator;

    public LottoMachine(RandomNumbersGenerator randomNumbersGenerator) {
        this.randomNumberGenerator = randomNumbersGenerator;
    }

    public Lottos createLottos(long lottoCnt) {
        List<List<Integer>> lottos = initLottosBy(lottoCnt);
        for (int i = 0; i < lottoCnt; i++) {
            lottos.get(i).addAll(randomNumberGenerator.createRandomNumbers());
        }
        return new Lottos(lottos);
    }

    private List<List<Integer>> initLottosBy(long lottoCnt) {
        List<List<Integer>> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCnt; i++) {
            lottos.add(new ArrayList<>());
        }
        return lottos;
    }

}
