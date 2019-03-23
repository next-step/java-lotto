import java.util.ArrayList;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {

    private static final List<Integer> LOTTO_NUMBERS;
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;

    static {
        LOTTO_NUMBERS = IntStream.rangeClosed(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER)
                .boxed()
                .collect(Collectors.toList());
    }

    public List<Integer> createNumbers() {
        Collections.shuffle(LOTTO_NUMBERS);
        List<Integer> selectedNumbers = LOTTO_NUMBERS.subList(0, 6);
        Collections.sort(selectedNumbers);
        return new ArrayList<>(selectedNumbers);
    }
}
