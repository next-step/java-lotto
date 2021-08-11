package step4.util;

import step4.LottoEntry;
import step4.LottoNumber;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class LottoRandomNumberGenerator implements LottoNumberGenerator {
    private final static Random random = new Random();

    @Override
    public List<Integer> generateNumbersForLotto() {
        return random.ints(LottoNumber.LOWER_BOUND, LottoNumber.UPPER_BOUND)
                .distinct()
                .limit(LottoEntry.LOTTO_NUMBER_SIZE)
                .boxed()
                .collect(Collectors.toList());
    }
}
