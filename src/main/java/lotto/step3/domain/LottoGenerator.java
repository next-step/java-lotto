package lotto.step3.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class LottoGenerator {

    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;
    private static final List<Integer> allLottoNumbers = createAllNumbers();

    public static Lotto createLotto() {
        Collections.shuffle(allLottoNumbers);
        List<Integer> randomLottoNumbers = allLottoNumbers.stream()
                .limit(LOTTO_SIZE)
                .sorted()
                .collect(Collectors.toList());
        return new Lotto(Collections.unmodifiableList(randomLottoNumbers));
    }

    private static List<Integer> createAllNumbers() {
        return IntStream
                .rangeClosed(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER)
                .boxed()
                .collect(Collectors.toList());
    }

}
