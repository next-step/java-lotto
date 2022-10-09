package lotto.utils;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoFactory {

    private static final List<LottoNumber> ALL_LOTTO_NUMBERS = IntStream.rangeClosed(LottoNumber.MIN_VALUE, LottoNumber.MAX_VALUE)
            .mapToObj(LottoNumber::new)
            .collect(Collectors.toList());

    private LottoFactory() {}

    public static List<Lotto> createLottos(int numberOfLottos) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < numberOfLottos; i++) {
            lottos.add(createLotto());
        }
        return lottos;
    }

    public static Lotto createLotto() {
        Collections.shuffle(ALL_LOTTO_NUMBERS);
        return new Lotto(new ArrayList<>(ALL_LOTTO_NUMBERS.subList(0, Lotto.SIZE_OF_NUMBERS)));
    }

}
