package step2;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class LottoRandomNumberGenerator implements LottoNumberGenerator {
    private final static int LOWER_BOUND = 1;
    private final static int UPPER_BOUND = 46;

    private final static Random random = new Random();

    @Override
    public List<Integer> generateNumbersForLotto() {
        return random.ints(LottoEntry.LOTTO_NUMBER_SIZE, LOWER_BOUND, UPPER_BOUND)
                .boxed()
                .collect(Collectors.toList());
    }
}
