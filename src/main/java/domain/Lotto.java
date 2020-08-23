package domain;

import strategy.LottoNumberGenerator;
import study.ValidateUtil;

import java.util.*;

import static java.util.stream.Collectors.toList;

public class Lotto {
    private Set<LottoNumber> numbers;

    private Lotto(Set<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    public static Lotto of(LottoNumberGenerator lottoNumberGenerator) {
        return Lotto.of("", lottoNumberGenerator);
    }

    public static Lotto of(String numbers, LottoNumberGenerator lottoNumberGenerator) {
        Set<LottoNumber> lottoNumbers = new TreeSet<>(lottoNumberGenerator.generator(numbers));
        ValidateUtil.validateLottoNumberCount(lottoNumbers);

        return new Lotto(lottoNumbers);
    }

    public List<Integer> getNumbers() {
        return numbers.stream()
                .map(LottoNumber::getValue)
                .collect(toList());
    }

    public boolean contains(LottoNumber target) {
        return numbers.contains(target);
    }

    public Integer getMatchCount(Lotto winningNumbers) {
        return numbers.stream()
                .filter(winningNumbers::contains)
                .map(e -> 1)
                .reduce(0, Integer::sum);
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
        return Objects.hash(numbers);
    }
}
