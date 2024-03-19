package model;

import java.util.ArrayList;
import java.util.List;

public class LottoFactory {

    public static Lottos create(final int lottoCount) {
        final List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto(RandomNumberGenerator.generate()));
        }
        return new Lottos(lottos);
    }

    public static Lottos create(final List<List<Integer>> inputs) {
        final List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < inputs.size(); i++) {
            lottos.add(new Lotto(inputs.get(i)));
        }
        return new Lottos(lottos);
    }
}
