package lotto.domain;

import lotto.domain.generator.LottoGenerator;
import lotto.domain.generator.RandomLottoGenerator;
import lotto.utils.LottoNumberValidator;

import java.util.List;

public class Lotto {

    private final List<Integer> lottoNumbers;

    public Lotto() {

        this(new RandomLottoGenerator());
    }

    public Lotto(LottoGenerator lottoGenerator) {

        List<Integer> lottoNumbers = lottoGenerator.generate();
        LottoNumberValidator.validate(lottoNumbers);
        sortLottoNumberAsc(lottoNumbers);

        this.lottoNumbers = lottoNumbers;
    }

    public boolean isLottoNumberMatchesCorrectCount(int correctCount, WonNumbers wonNumbers) {

        return getWonNumbersContainsCount(wonNumbers) == correctCount;
    }

    private long getWonNumbersContainsCount(WonNumbers wonNumbers) {

        return wonNumbers.getWonNumbers()
                .stream()
                .filter(lottoNumbers::contains)
                .count();
    }

    private void sortLottoNumberAsc(List<Integer> lottoNumbers) {

        lottoNumbers.sort(Integer::compareTo);
    }

    @Override
    public String toString() {

        return lottoNumbers.toString();
    }
}
