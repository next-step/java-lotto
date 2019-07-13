package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGeneratorRandom implements LottoGenerator {
    private List<Integer> baseNumbers;

    public LottoGeneratorRandom() {
        baseNumbers = new ArrayList<>();
        for (int i = 1; i <= LOTTO_BOUND; i++) {
            baseNumbers.add(i);
        }
    }

    private LottoAuto generateLotto() {
        Collections.shuffle(baseNumbers);
        return Lotto.of(baseNumbers.subList(0, LOTTO_NUMBER_MAX_COUNT));
    }

    @Override
    public List<Lotto> generate(Money money) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < money.countOfBuyingLotto(); i++) {
            lottos.add(generateLotto());
        }
        return lottos;
    }
}