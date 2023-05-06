package lotto.utils;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.domain.Lotto.LOTTO_SIZE;
import static lotto.domain.LottoNumber.LOTTO_NUMBER_MAX;
import static lotto.domain.LottoNumber.LOTTO_NUMBER_MIN;

public class LottoIssuer {

    private static final int BEGIN_INDEX = 0;
    private static final List<Integer> ALL_LOTTO_NUMBERS = IntStream.rangeClosed(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX)
            .boxed()
            .collect(Collectors.toList());

    public static List<Lotto> issueLottos(long lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = BEGIN_INDEX; i < lottoCount; i++) {
            lottos.add(issueLotto());
        }
        return lottos;
    }

    private static Lotto issueLotto() {
        Collections.shuffle(ALL_LOTTO_NUMBERS);
        List<Integer> numbers = ALL_LOTTO_NUMBERS.subList(BEGIN_INDEX, LOTTO_SIZE);
        return new Lotto(numbers);
    }
}
