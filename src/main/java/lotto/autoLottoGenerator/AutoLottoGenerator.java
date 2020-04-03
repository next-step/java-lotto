package lotto.autoLottoGenerator;

import lotto.model.Lotto;
import lotto.model.LottoNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class AutoLottoGenerator {
    public static List<Lotto> generate(int autoLottoCount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < autoLottoCount; i++) {
            lottos.add(generateOneLotto());
        }

        return lottos;
    }

    private static Lotto generateOneLotto() {
        List<Integer> lottoPool = LottoNumber.getLottoPool();
        Collections.shuffle(lottoPool);
        return lottoPool.stream()
                .map(it -> new LottoNumber(it))
                .limit(6)
                .collect(collectingAndThen(toList(), Lotto::new));
    }
}