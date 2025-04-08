package util;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberGenerator {
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int UPPER_BOUND = 45;
    private static final int LOWER_BOUND = 1;
    private final List<Integer> lottoNumbers;

    public LottoNumberGenerator() {
        lottoNumbers = IntStream.rangeClosed(LOWER_BOUND, UPPER_BOUND)
                .boxed()
                .collect(Collectors.toList());
    }

    public List<Integer> getLottoNumbers() {
        List<Integer> shuffledNumbers = new java.util.ArrayList<>(List.copyOf(lottoNumbers)); // Create a copy to avoid modifying the original list
        Collections.shuffle(shuffledNumbers);
        return shuffledNumbers.subList(0, LOTTO_NUMBER_COUNT);
    }

}
