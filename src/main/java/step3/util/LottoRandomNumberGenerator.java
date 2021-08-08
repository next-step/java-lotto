package step3.util;

import step3.LottoEntry;
import step3.util.LottoNumberGenerator;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

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
