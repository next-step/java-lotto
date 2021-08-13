package lotto.domain;

import lotto.domain.exception.NumberCountException;
import lotto.domain.exception.NumberDuplicateException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class Lotto {

    private static final int LIMIT_SIZE = 6;

    private final List<LottoNumber> lottoNumbers = new ArrayList<>();

    public Lotto(final List<Integer> numbers) {
        validateNumbers(numbers);
        addLottoNumber(numbers);
    }

    private void validateNumbers(final List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty() || numbers.size() != LIMIT_SIZE) {
            throw new NumberCountException();
        }
        if (validateDuplicate(numbers)) {
            throw new NumberDuplicateException();
        }
    }

    private boolean validateDuplicate(final List<Integer> numbers) {
        Set<Integer> numbersSet = new HashSet<>(numbers);
        return numbersSet.size() != LIMIT_SIZE;
    }

    private void addLottoNumber(final List<Integer> numbers) {
        for (int number : numbers) {
            lottoNumbers.add(LottoNumberFactory.getLottoNumber(number));
        }
    }

    public MatchingCount getMatchingCount(final Lotto lotto) {
        MatchingCount matchingCount = new MatchingCount();

        for (LottoNumber lottoNumber : lottoNumbers) {
            matchingCount = lotto.addMatchingCount(lottoNumber, matchingCount);
        }

        return matchingCount;
    }

    private MatchingCount addMatchingCount(final LottoNumber lottoNumber, final MatchingCount matchingCount) {
        if (hasLottoNumber(lottoNumber)) {
            return matchingCount.increment();
        }
        return matchingCount;
    }

    public boolean hasLottoNumber(final LottoNumber lottoNumber) {
        return this.lottoNumbers.contains(lottoNumber);
    }

    public List<LottoNumber> getLottoNumbers() {
        return this.lottoNumbers;
    }

}
