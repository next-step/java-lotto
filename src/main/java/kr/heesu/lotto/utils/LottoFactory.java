package kr.heesu.lotto.utils;

import kr.heesu.lotto.domain.Lotto;
import kr.heesu.lotto.domain.LottoNumber;
import kr.heesu.lotto.domain.Lottos;
import kr.heesu.lotto.domain.PurchaseAmount;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoFactory {
    private static final int SIZE = 6;
    private static final List<LottoNumber> RANGE;

    static {
        RANGE = IntStream.range(1, 46)
                .mapToObj(LottoNumber::of)
                .collect(Collectors.toList());
    }

    private LottoFactory() {}

    public static List<LottoNumber> generateLottoNumbers() {
        Collections.shuffle(RANGE);

        return Collections.unmodifiableList(RANGE.subList(0, SIZE));
    }

    public static Lotto createLotto(List<LottoNumber> numbers) {
        return Lotto.of(numbers);
    }

    public static Lottos createMultipleLottos(PurchaseAmount amount) {
        List<Lotto> lottos = Stream.generate(LottoFactory::generateLottoNumbers)
                .limit(amount.getSize())
                .map(LottoFactory::createLotto)
                .collect(Collectors.toList());

        return Lottos.of(lottos);
    }
}
