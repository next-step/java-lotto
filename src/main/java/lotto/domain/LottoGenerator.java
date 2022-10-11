package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {

    private static final int LOTTO_NUMBER_MAX_SIZE = 6;
    private static final List<Integer> LOTTO_NUMBER_RANGE = IntStream.range(1, 46)
            .boxed()
            .collect(Collectors.toUnmodifiableList());

    private LottoGenerator() {
    }

    public static List<Lotto> generate(int size) {
        validateSize(size);
        List<Integer> lottoNumberRange = new ArrayList<>(LOTTO_NUMBER_RANGE);

        List<Lotto> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Collections.shuffle(lottoNumberRange);
            result.add(new Lotto(lottoNumberRange.subList(0, LOTTO_NUMBER_MAX_SIZE)));
        }
        return result;
    }

    private static void validateSize(int size) {
        if (size < 1) {
            throw new IllegalArgumentException("1이상의 size가 필요합니다.");
        }
    }
}
