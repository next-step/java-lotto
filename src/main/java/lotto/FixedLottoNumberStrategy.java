package lotto;

import java.util.List;

public class FixedLottoNumberStrategy implements LottoNumberStrategy {
    private final List<Integer> fixedLottoNumbers;
    @Override
    public List<Integer> generate() {
        return fixedLottoNumbers;
    }

    private FixedLottoNumberStrategy(List<Integer> fixedLottoNumbers) {
        this.fixedLottoNumbers = fixedLottoNumbers;
    }

    public static FixedLottoNumberStrategy from(List<Integer> fixedLottoNumbers) {
        return new FixedLottoNumberStrategy(fixedLottoNumbers);
    }
}
