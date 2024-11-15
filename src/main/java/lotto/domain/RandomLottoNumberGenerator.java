package lotto.domain;

import java.util.List;
import lotto.util.UniqueRandomNumberProvider;

public class RandomLottoNumberGenerator implements LottoNumberGenerator {
    @Override
    public List<Integer> generate(int min, int max, int size) {
        return UniqueRandomNumberProvider.provideInRange(min, max, size);
    }
}
