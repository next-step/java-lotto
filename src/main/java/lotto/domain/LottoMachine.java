package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    public static Lottos buy(int count) {
        List<Lotto> lottoList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            lottoList.add(LottoNumberGenerator.generate());
        }

        return Lottos.copyOf(lottoList);
    }
}
