package lotto.domain.generator;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class ManualLottosGenerator implements LottosGenerator {
    private final List<Lotto> manualLottos;

    public ManualLottosGenerator(List<Lotto> manualLottos) {
        this.manualLottos = List.copyOf(manualLottos);
    }

    @Override
    public Lottos generate() {
        return new Lottos(manualLottos);
    }
}
