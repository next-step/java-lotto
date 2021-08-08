package lotto.domain;

import java.util.*;
import java.util.function.Predicate;

public class Lotto {
    private final List<Integer> lottoNumber;
    private final NumberGenerator numberGenerator;
    private SameNumbersCount sameNumbers;

    public Lotto(NumberGenerator numberGenerator) {
        this.numberGenerator  = numberGenerator;
        this.lottoNumber = createRandomNumbers();
        sortLottoNumbers();
    }

    private List<Integer> createRandomNumbers() {
        return numberGenerator.generateNumber();
    }

    private void sortLottoNumbers() {
        Collections.sort(lottoNumber);
    }

    public List<Integer> getLottoNumber() {
        return Collections.unmodifiableList(lottoNumber);
    }

    public void getLottoRank(List<Integer> winningNumber) {
        long sameCount = lottoNumber.stream()
                .filter(integer -> winningNumber.stream().anyMatch(Predicate.isEqual(integer)))
                .count();
        this.sameNumbers = sameNumbers.getSameNumbersCount(sameCount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumber, lotto.lottoNumber) && Objects.equals(numberGenerator, lotto.numberGenerator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber, numberGenerator);
    }

}
