package lotto.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {
    private final List<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        numbers.sort(LottoNumber::isGreaterThan);
        this.numbers = numbers;
    }

    public static Lotto of(List<Integer> numbers) {
        List<LottoNumber> lottoNumbers = numbers.stream().map(LottoNumber::new)
                .collect(Collectors.toList());

        return new Lotto(lottoNumbers);
    }

    public int matchNumberCnt(Lotto winningLotto) {
        return (int) numbers.stream()
                .filter(winningLotto.numbers::contains)
                .count();
    }

    public boolean haNumber(LottoNumber bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public List<LottoNumber> getNumbers() {
        return numbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lotto lotto = (Lotto) o;

        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return numbers != null ? numbers.hashCode() : 0;
    }
}
