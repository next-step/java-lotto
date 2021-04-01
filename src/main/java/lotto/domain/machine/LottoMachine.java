package lotto.domain.machine;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoBall;

public class LottoMachine {
    private final List<LottoBall> candidates;
    private final LottoGenerator lottoGenerator;

    public LottoMachine(LottoGenerator lottoGenerator) {
        candidates = new ArrayList<>(45);
        for (int i = 1; i <= 45; i++) {
            candidates.add(new LottoBall(i));
        }
        this.lottoGenerator = lottoGenerator;
    }

    public Lotto generate() {
        return lottoGenerator.generate(candidates);
    }
}
