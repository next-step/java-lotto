package step2.service;

import java.util.List;

public class LottoNumberGenerator {

    private final FixedLottoNumbers fixedLottoNumbers;

    public LottoNumberGenerator() {
        this.fixedLottoNumbers = new FixedLottoNumbers();
    }

    public List<Integer> generateLottoNumbers() {
        return fixedLottoNumbers.getRandomNumbers();
    }
}
