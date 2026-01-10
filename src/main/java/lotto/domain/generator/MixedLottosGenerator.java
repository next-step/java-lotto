package lotto.domain.generator;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class MixedLottosGenerator implements LottosGenerator {
    private final LottosGenerator manual;
    private final LottosGenerator auto;

    public MixedLottosGenerator(LottosGenerator manual, LottosGenerator auto) {
        this.manual = manual;
        this.auto = auto;
    }

    @Override
    public Lottos generate() {
        Lottos manualIssued = manual.generate();
        Lottos autoIssued = auto.generate();

        List<Lotto> merged = new ArrayList<>(manualIssued.values());
        merged.addAll(autoIssued.values());

        return new Lottos(merged);
    }
}
