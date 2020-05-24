package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {

    private static final int LOTTO_GENERATE_COUNT = 6;

    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;


    public Lotto autoGenerate() {
        List<Integer> generateNumbers = generateLottoNumbers();
        Collections.shuffle(generateLottoNumbers());
        return Lotto.of(generateNumbers.subList(0, LOTTO_GENERATE_COUNT));
    }

    private List<Integer> generateLottoNumbers() {
        return IntStream.range(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX + 1)
                .boxed()
                .collect(Collectors.toList());
    }
}
