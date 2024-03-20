package model;

import java.util.ArrayList;
import java.util.List;

public class LottoFactory {

    public static Lottos create(final int lottoCount, final List<List<Integer>> inputs) {
        final List<Lotto> lottos = new ArrayList<>();
        for (final List<Integer> input : inputs) {
            lottos.add(new Lotto(input));
        }
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto(RandomNumberGenerator.generate()));
        }
        return new Lottos(lottos);
    }
}
