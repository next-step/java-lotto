package step2.domain;

import step2.strategy.NumberGeneratorStrategy;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Lotto {
    private static final int NONE_MATCH_COUNT = 0;

    private LottoNumbers lottoNumbers;

    private Lotto(NumberGeneratorStrategy generatorStrategy) {
        lottoNumbers = LottoNumbers.create(generatorStrategy);
    }

    private Lotto(String[] splitNumbers) {
        lottoNumbers = LottoNumbers.of(splitNumbers);
    }

    public static Lotto generate(NumberGeneratorStrategy generatorStrategy) {
        return new Lotto(generatorStrategy);
    }

    public static Lotto of(String[] splitNumbers) {
        return new Lotto(splitNumbers);
    }

    public int match(Lotto lotto) {
        return lottoNumbers.match(lotto.getLottoNumbers());
    }

    public boolean matchBonus(Number bonusNumber) {
        return lottoNumbers.match(Collections.singletonList(bonusNumber)) > NONE_MATCH_COUNT;
    }

    public List<Number> getLottoNumbers() {
        return lottoNumbers.getNumbers();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(getLottoNumbers(), lotto.getLottoNumbers());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLottoNumbers());
    }

    @Override
    public String toString() {
        return "Lotto{" +
                "lottoNumbers=" + lottoNumbers +
                '}';
    }
}
