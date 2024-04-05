package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class LottoGenerator {
    private LottoGenerator() {
    }

    public static Lottos generateLottos(LottoFee lottoFee, List<List<Integer>> manualLottos) {
        Lottos lottos = new Lottos();
        lottos.add(generateAutoLotto(lottoFee.totalCount() - manualLottos.size()));
        lottos.add(generateManualLotto(manualLottos));

        return lottos;
    }

    private static List<Lotto> generateAutoLotto(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(generateLotto());
        }
        return lottos;
    }

    private static List<Lotto> generateManualLotto(List<List<Integer>> manualLottos) {
        List<Lotto> lottos = new ArrayList<>();
        for (List<Integer> lottoNumbers : manualLottos) {
            lottos.add(Lotto.create(lottoNumbers));
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
