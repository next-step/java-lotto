package lotto.strategy;

import java.util.List;

public class FixedLottoNumberStrategy implements LottoNumberStrategy {
    private final List<Integer> fixedLottoNumbers;

    public FixedLottoNumberStrategy(List<Integer> fixedLottoNumbers) {
        this.fixedLottoNumbers = fixedLottoNumbers;
    }

    @Override
    public List<Integer> generate() {
        return fixedLottoNumbers;
    }
}
