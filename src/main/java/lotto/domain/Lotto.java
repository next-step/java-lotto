package lotto.domain;

import lotto.common.NumberGenerator;
import lotto.exception.LottoNumberDuplicateException;
import lotto.exception.LottoNumberLengthException;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Lotto {
    public final List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        validLottoNumberSize(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
        duplicateValidation(lottoNumbers);
    }

    public static Lotto from(NumberGenerator numberGenerator) {
        return new Lotto(numberGenerator.generateNumber());
    }
    
    private void duplicateValidation(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.stream().distinct().count() < 6) {
            throw new LottoNumberDuplicateException();
        }
    }

    private void validLottoNumberSize(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() > 6) {
            throw new LottoNumberLengthException();
        }
    }

    public static Lotto from(final List<Integer> numbers) {
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
