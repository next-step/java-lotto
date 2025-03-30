package lotto;

import java.util.ArrayList;
import java.util.List;

public class FixedLottoNumberGenerator implements LottoNumberGenerator {

    private final List<Integer> fixedNumbers;

    public FixedLottoNumberGenerator(List<Integer> fixedNumbers) {
        this.fixedNumbers = new ArrayList<>(fixedNumbers);
    }

    @Override
    public List<Integer> generate() {
        return fixedNumbers;
    }
}
