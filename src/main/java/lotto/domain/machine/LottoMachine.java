package lotto.domain.machine;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;

public class LottoMachine {
    private final List<Integer> candidates;
    private final LottoGenerator lottoGenerator;

    public LottoMachine(LottoGenerator lottoGenerator) {
        candidates = new ArrayList<>(45);
        for (int i = 1; i <= 45; i++) {
            candidates.add(i);
        }
        this.lottoGenerator = lottoGenerator;
    }

    public Lotto generate() {
        return lottoGenerator.generate(candidates);
    }
}
