package lotto.domain;

import lotto.dto.WinningNumber;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Lotto {
    public static final String INVALID_NUMBERS_SIZE_ERR_MSG = "로또 숫자의 개수가 유효하지 않습니다.";
    public static final int VALID_NUMBERS_SIZE = 6;

    private final Set<LottoNumber> numbers;

    private Lotto(Collection<Integer> numbers) {
        this.numbers = Collections.unmodifiableSet(getLottoNumbersFrom(numbers));
        validateNumbersSize();
    }

    public static Lotto of(Collection<Integer> numbers) {
        return new Lotto(numbers);
    }

    public static Lotto of(Integer... numbers) {
        return new Lotto(Arrays.asList(numbers));
    }

    private Set<LottoNumber> getLottoNumbersFrom(Collection<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::from)
                .collect(Collectors.toCollection(TreeSet::new));
    }

    private void validateNumbersSize() {
        if (numbers.size() != VALID_NUMBERS_SIZE) {
            throw new IllegalStateException(INVALID_NUMBERS_SIZE_ERR_MSG);
        }
    }

    public int getMatchedCountCompareTo(WinningNumber winningNumber) {
        Lotto winningLotto = winningNumber.getWinningLotto();
        return (int) numbers.stream()
                .filter(winningLotto.numbers::contains)
                .count();
    }

    public Set<LottoNumber> getNumbers() {
        return numbers;
    }

    public boolean contains(WinningNumber winningNumber) {
        LottoNumber bonusNumber = winningNumber.getBonusNumber();
        return contains(bonusNumber);
    }

    public boolean contains(LottoNumber lottoNumber) {
        return numbers.contains(lottoNumber);
    }

    @Override
    public String toString() {
        return "Lotto{" +
                "numbers=" + numbers +
                '}';
    }
}
