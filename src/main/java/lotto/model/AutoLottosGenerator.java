package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class AutoLottosGenerator implements LottosGenerator {
    private final Count count;

    public AutoLottosGenerator(Count count) {
        this.count = count;
    }

    @Override
    public Lottos generate() {
        return createLottos(count);
    }

    private static Lottos createLottos(Count count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count.value(); i++) {
            lottos.add(new Lotto());
        }
        return new Lottos(lottos);
    }
}
