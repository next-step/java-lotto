package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class LottoGenerator {

    private LottoGenerator() {
    }

    public static Lottos generateLottos(LottoFee lottoFee) {
        Lottos lottos = new Lottos();
        for (int i = 0; i < lottoFee.convertToGameUnit(); i++) {
            lottos.add(generateLotto());
        }
        return lottos;
    }

    public static Lotto generateLotto() {
        List<Integer> cachedLottoNumber = LottoNumber.ALL_NUMBERS;
        Collections.shuffle(cachedLottoNumber);
        cachedLottoNumber = cachedLottoNumber.subList(0,6);
        Collections.sort(cachedLottoNumber);
        return Lotto.create(cachedLottoNumber);
    }
}
