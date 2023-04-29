package step3.domain.model.Lotto;


import step3.domain.strategy.lotto.LottoPolicyStrategy;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private List<Lotto> lottos = new ArrayList<>();

    public Lottos(int lottoCount) {
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(Lotto.from(new LottoPolicyStrategy()));
        }
    }

    public static Lottos from(int lottoCount, int bonusNumber) {
        if (lottoCount < 0) {
            throw new IllegalArgumentException("음수의 갯수는 잘못된 값입니다.");
        }

        if (bonusNumber < 0) {
            throw new IllegalArgumentException(String.format("음슈의 보너스 번호는 잘못된 값입니다. 보너스 번호 %d", bonusNumber));
        }
        return new Lottos(lottoCount);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
