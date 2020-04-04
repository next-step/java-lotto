package lotto.autoLottoGenerator;

import lotto.model.lottos.Lotto;
import lotto.model.lottos.LottoNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Comparator.comparing;
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
                .sorted(comparing(LottoNumber::getLottoNumber))
                .collect(collectingAndThen(toList(), Lotto::new));
    }
}