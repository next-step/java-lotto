package lottos.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoRandomGenerator implements LottoGenerator {

    private static final int COUNT_OF_LOTTO = 6;
    private static final int COUNT_OF_BONUS = 1;
    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 45;

    @Override
    public List<Integer> generate() {
        List<Integer> numbers = getNumbers();
        Collections.shuffle(numbers);

        return numbers.stream()
                .limit(COUNT_OF_LOTTO + COUNT_OF_BONUS)
                .sorted()
                .collect(Collectors.toList());
    }

    private List<Integer> getNumbers() {
        return IntStream.rangeClosed(MINIMUM_NUMBER, MAXIMUM_NUMBER)
                .boxed()
                .collect(Collectors.toList());
    }
}
