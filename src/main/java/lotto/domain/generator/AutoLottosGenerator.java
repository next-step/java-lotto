package lotto.domain.generator;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class AutoLottosGenerator  implements LottosGenerator {
    private final int count;
    private final LottoNumberGenerator numberGenerator;

    public AutoLottosGenerator(int count, LottoNumberGenerator numberGenerator) {
        if (count < 0) {
            throw new IllegalArgumentException("자동 로또 개수는 0 이상이어야 합니다.");
        }
        this.count = count;
        this.numberGenerator = numberGenerator;
    }

    @Override
    public Lottos generate() {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto(numberGenerator.generate()));
        }
        return new Lottos(lottos);
    }
}
