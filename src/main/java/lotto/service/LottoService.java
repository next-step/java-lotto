package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.Lottos;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LottoService {

    private static final int RANGE_INITIAL = 0;

    public Lottos issueLottos(int count, LottoGenerator lottoGenerator) {
        List<Lotto> lottos = new ArrayList<>();

        IntStream.range(RANGE_INITIAL, count)
                .forEach(v -> lottos.add(Lotto.of(lottoGenerator)));

        return new Lottos(lottos);
    }
}
