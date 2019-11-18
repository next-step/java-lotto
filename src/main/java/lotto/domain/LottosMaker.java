package lotto.domain;

import java.util.List;

public class LottosMaker implements LottosGenerator {

    @Override
    public Lottos generate(List<Lotto> lottos) {
        return new Lottos(lottos);
    }
}
