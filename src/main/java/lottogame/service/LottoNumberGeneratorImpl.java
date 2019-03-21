package lottogame.service;

import lottogame.domain.LottoNumber;
import lottogame.domain.LottoNumberPackage;
import org.apache.commons.lang.math.LongRange;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class LottoNumberGeneratorImpl implements LottoNumberGenerator {

    private static final List<Integer> numberPool =
            IntStream.rangeClosed(LottoNumber.MINIMUM_LOTTO_NUMBER, LottoNumber.MAXIMUM_LOTTO_NUMBER)
                    .boxed()
                    .collect(Collectors.toList());

    @Override
    public LottoNumberPackage generate() {
        return new LottoNumberPackage(getLottoNumbers());
    }

    @Override
    public List<LottoNumberPackage> generate(long count) {
        return LongStream.rangeClosed(1, count)
                        .mapToObj(index -> generate())
                        .collect(Collectors.toList());
    }

    Set<Integer> getLottoNumbers() {
        Collections.shuffle(numberPool);

        return numberPool.stream()
                        .limit(LottoNumberPackage.LOTTO_GAME_SIZE)
                        .sorted()
                        .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    public static List<Integer> getNumberPool() {
        return numberPool;
    }
}