package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoBundle {

    public static List<Lotto> lottoBundle(int count, Shuffle suffle) {

        List<Lotto> lottos = new ArrayList<>();
        for (int idx = 0; idx < count; idx++) {
            lottos.add(LottoGenerator.lottoGenerator(suffle));
        }

        return lottos;
    }
}
