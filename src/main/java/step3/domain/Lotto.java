package step3.domain;

import step3.exception.LottoCountBoundException;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {

    private final List<Integer> lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {

        validLottoCount(lottoNumbers);

        this.lottoNumbers = lottoNumbers
                .stream()
                .sorted()
                .collect(Collectors.toList());
    }

    private void validLottoCount(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != 6) {
            throw new LottoCountBoundException();
        }
    }

    public int matchLottoNumbers(List<Integer> matchLottoNumbers) {
        return (int) lottoNumbers.stream()
                .filter(matchLottoNumbers::contains)
                .count();
    }

    public String getLottoNumbersToStringList() {
        return lottoNumbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
