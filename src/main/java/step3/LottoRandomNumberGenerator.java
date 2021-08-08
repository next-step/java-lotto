package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoRandomNumberGenerator implements LottoNumberGenerator {
    private final static Random random = new Random();

    @Override
    public List<Integer> generateNumbersForLotto() {
        return random.ints(LottoEntry.LOWER_BOUND, LottoEntry.UPPER_BOUND)
                .distinct()
                .limit(LottoEntry.LOTTO_NUMBER_SIZE)
                .boxed()
                .collect(Collectors.toList());
    }
}
