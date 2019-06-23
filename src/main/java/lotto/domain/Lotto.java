package lotto.domain;

import lotto.domain.generator.LottoGenerator;
import lotto.domain.generator.RandomLottoGenerator;

import java.util.List;

public class Lotto {

    private final List<Integer> lottoNumbers;

    public Lotto() {

        this(new RandomLottoGenerator());
    }

    public Lotto(LottoGenerator lottoGenerator) {

        this.lottoNumbers = lottoGenerator.generate();
        this.lottoNumbers.sort(Integer::compareTo);
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

    @Override
    public String toString() {

        return lottoNumbers.toString();
    }
}
