package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class AutoLottosGenerator implements LottosGenerator {
    private final LottoPurchasePlan plan;

    public AutoLottosGenerator(LottoPurchasePlan plan) {
        this.plan = plan;
    }

    @Override
    public Lottos generate() {
        return createLottos(plan.autoCount());
    }

    private static Lottos createLottos(Count count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count.value(); i++) {
            lottos.add(new Lotto());
        }
        return new Lottos(lottos);
    }
}
