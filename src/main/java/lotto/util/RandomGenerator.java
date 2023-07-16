package lotto.util;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.request.ManualRequest;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomGenerator implements LottoGenerator{

    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final int START_INDEX = 0;
    private static final int LOTTO_SIZE = 6;
    private static final List<Integer> lottoNumbers = IntStream.rangeClosed(START_NUMBER, END_NUMBER)
            .boxed()
            .collect(Collectors.toList());

    public Lotto generateAutoLotto() {
        Collections.shuffle(lottoNumbers);
        return new Lotto(lottoNumbers.subList(START_INDEX, LOTTO_SIZE));
    }

    public Lottos generateManualLotto(ManualRequest manualRequest) {
        return Lottos.from(manualRequest);
    }
}
