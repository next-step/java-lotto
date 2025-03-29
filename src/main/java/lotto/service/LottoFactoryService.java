package lotto.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import lotto.domain.Lotto;

import static java.util.stream.Collectors.toList;
import static lotto.domain.Lotto.LOTTO_NUMBER_END;
import static lotto.domain.Lotto.LOTTO_NUMBER_START;

public class LottoFactoryService {
    private static final int LOTTO_NUMBER_COUNT = 6;

    public static List<Lotto> createLottos(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto(generateLottoNumbers()));
        }

        return lottos;
    }

    private static List<Integer> generateLottoNumbers() {
        return new Random().ints(LOTTO_NUMBER_START, LOTTO_NUMBER_END + 1)
            .distinct()
            .limit(LOTTO_NUMBER_COUNT)
            .boxed()
            .sorted()
            .collect(toList());
    }
}
