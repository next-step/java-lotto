package LottoTest;

import lotto.LottoGenerator;

import java.util.Arrays;
import java.util.List;

public class FixedLottoGenerator implements LottoGenerator {
    @Override
    public List<Integer> generate() {
        return Arrays.asList(1, 2, 3, 4, 5, 6);
    }
}
