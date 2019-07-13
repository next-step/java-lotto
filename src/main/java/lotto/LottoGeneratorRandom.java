package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGeneratorRandom implements LottoGenerator {
    private List<Integer> baseNumbers;
    private Money money;
    private int manualCount;

    private LottoGeneratorRandom() {
        baseNumbers = new ArrayList<>();
        for (int i = 1; i <= LOTTO_BOUND; i++) {
            baseNumbers.add(i);
        }
    }

    public LottoGeneratorRandom(Money money, int manualCount) {
        this();
        this.money = money;
        this.manualCount = manualCount;
    }

    private LottoAuto generateLotto() {
        Collections.shuffle(baseNumbers);
        return LottoAuto.of(baseNumbers.subList(0, LOTTO_NUMBER_MAX_COUNT));
    }

    @Override
    public List<Lotto> generate() {
        List<Lotto> lottos = new ArrayList<>();
        int autoLottoCount = this.money.countOfBuyingLotto() - manualCount;
        for (int i = 0; i < autoLottoCount; i++) {
            lottos.add(generateLotto());
        }
        return lottos;
    }
}