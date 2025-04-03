package domain.generator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomLottoNumberGenerator implements LottoNumberGenerator {
    private static final List<Integer> CACHED_NUMBERS = new ArrayList<>();
    static {
        for (int i = MIN_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i++) {
            CACHED_NUMBERS.add(i);
        }
    }

    @Override
    public List<Integer> generate()  {
        List<Integer> allNumbers = new ArrayList<>(CACHED_NUMBERS);
        Collections.shuffle(allNumbers);
        List<Integer> lottoNumbers = allNumbers.subList(0, LOTTO_NUMBER_COUNT);
        Collections.sort(lottoNumbers);
        return new ArrayList<>(lottoNumbers);
    }
}
