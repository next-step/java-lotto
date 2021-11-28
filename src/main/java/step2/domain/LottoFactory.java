package step2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class LottoFactory {
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_NUMBER_TOTAL_COUNT = 6;
    private static final int LOTTO_NUMBER_MIN_INDEX = 0;
    private static final int LOTTO_NUMBER_MAX_INDEX = LOTTO_NUMBER_TOTAL_COUNT - 1;

    private static final List<Integer> numbers = IntStream
            .rangeClosed(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER)
            .boxed()
            .collect(toList());

    private LottoFactory() {}

    public static Lotto create() {
        List<Integer> lottoNumbers = generateLottoNumbers();
        List<Integer> unmodifiableLottoNumbers = Collections.unmodifiableList(lottoNumbers);
        return new Lotto(unmodifiableLottoNumbers);
    }

    private static List<Integer> generateLottoNumbers() {
        List<Integer> copyOfNumbers = new ArrayList<>(numbers);
        Collections.shuffle(copyOfNumbers);
        return IntStream.rangeClosed(LOTTO_NUMBER_MIN_INDEX, LOTTO_NUMBER_MAX_INDEX)
                        .mapToObj(copyOfNumbers::get)
                        .sorted()
                        .collect(toList());
    }

}
