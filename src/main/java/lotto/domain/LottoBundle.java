package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoBundle {

    public static Lottos lottoBundle(final int count){

        final List<Lotto> lottos = new ArrayList<>();

        for(int idx=0; idx<count; idx++){
            lottos.add(LottoGenerator.lottoGenerator());
        }

        return new Lottos(lottos);
    }
}
