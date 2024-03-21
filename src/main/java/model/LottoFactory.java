package model;

import java.util.List;

public class LottoFactory {

    public static Lottos create(final int lottoCount, final Inputs inputs) {
        final List<Lotto> lottos = inputs.createLottos();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto(RandomNumberGenerator.generate()));
        }
        return new Lottos(lottos);
    }
}
