package lotto.domain;

import lotto.common.NumberGenerator;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Lotto {
    public final List<LottoNumber> lottoNumbers;

    public Lotto(NumberGenerator numberGenerator) {
        this.lottoNumbers = numberGenerator.generateNumber();
    }

    public Lotto(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto getInstanceByInteger(final List<Integer> numbers) {
        return new Lotto(numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList()));
    }

    public int compareLotto(Lotto otherLotto) {
        long count = lottoNumbers.stream()
                .filter(lottoNumber -> otherLotto.lottoNumbers.stream()
                        .anyMatch(Predicate.isEqual(lottoNumber)))
                .count();
        return Math.toIntExact(count);
    }

    public boolean contains(LottoNumber bonusNumber) {
        return lottoNumbers.contains(bonusNumber);
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }
}
