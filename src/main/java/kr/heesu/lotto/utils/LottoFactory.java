package kr.heesu.lotto.utils;

import kr.heesu.lotto.domain.Lotto;
import kr.heesu.lotto.domain.LottoNumber;
import kr.heesu.lotto.domain.Lottos;
import kr.heesu.lotto.domain.PurchaseAmount;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoFactory {
    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;
    private static final int SIZE = 6;
    private static final List<LottoNumber> RANGE;

    static {
        RANGE = IntStream.rangeClosed(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX)
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

    public static Lottos createLottosAutomatic(PurchaseAmount amount) {
        Set<Lotto> lottoSet = new HashSet<>();

        while (lottoSet.size() < amount.getSize()) {
            List<LottoNumber> lottoNumbers = generateLottoNumbers();
            lottoSet.add(createLotto(lottoNumbers));
        }

        return Lottos.of(lottoSet);
    }
}
