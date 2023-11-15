package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    private static final int LOTTO_SIZE = 6;
    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);

        this.lottoNumbers = numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public int matchCount(Lotto otherLotto) {
        return (int) getIntegerLottoNumbers().stream()
                .filter(otherLotto::isMatchNumber)
                .count();
    }

    public boolean isContain(LottoNumber bonusNumber) {
        return this.lottoNumbers.contains(bonusNumber);
    }

    private boolean isMatchNumber(int number) {
        return getIntegerLottoNumbers().contains(number);
    }

    private List<Integer> getIntegerLottoNumbers() {
        return this.lottoNumbers.stream()
                .map(LottoNumber::getLottoNumber)
                .collect(Collectors.toUnmodifiableList());
    }

    private void validate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);

        if (uniqueNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또의 숫자는 중복없이 6개여야 합니다.");
        }
    }

    @Override
    public String toString() {
        return getIntegerLottoNumbers().toString();
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
