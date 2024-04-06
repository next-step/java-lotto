package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public final class LottoGenerator {
    private LottoGenerator() {
    }

    public static Lottos generateLottos(LottoFee lottoFee, List<List<Integer>> manualLottos) {
        Lottos lottos = new Lottos();
        lottos.addAll(generateAutoLotto(lottoFee.totalCount() - manualLottos.size()));
        lottos.addAll(generateManualLotto(manualLottos));

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
        List<Integer> cachedLottoNumber = LottoNumber.LOTTO_NUMBER_CACHE.keySet()
                                                                        .stream()
                                                                        .collect(Collectors.toList());
        Collections.shuffle(cachedLottoNumber);
        cachedLottoNumber = cachedLottoNumber.subList(0,6);
        Collections.sort(cachedLottoNumber);
        return Lotto.create(cachedLottoNumber);
    }
}
