package lotto.domain;

import lotto.generator.ManualNumberGenerator;
import lotto.generator.NumberGenerator;
import lotto.generator.RandomNumberGenerator;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {

    public static final int MAX_MATCH_NUMBER = 6;

    private List<LottoNumber> lotto;

    public Lotto(NumberGenerator numberGenerator) {
        this.lotto = numberGenerator.generate();
    }

    public int getSameNumberCount(Lotto winning) {
        if (this.equals(winning)) return MAX_MATCH_NUMBER;

        List<LottoNumber> winningNumbers = winning.lotto;

        return winningNumbers.stream()
                .filter(winningNum -> lotto.contains(winningNum))
                .collect(Collectors.toList())
                .size();
    }

    public List<LottoNumber> getLottoNumbers() {
        return this.lotto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto1 = (Lotto) o;
        return Objects.equals(lotto, lotto1.lotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotto);
    }

}
