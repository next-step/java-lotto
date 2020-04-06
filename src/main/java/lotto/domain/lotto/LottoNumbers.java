package lotto.domain.lotto;

import lotto.exception.ValidLottoException;

import java.util.*;
import java.util.stream.Collectors;

public class LottoNumbers {

    private static final String LOTTO_VALID_ONLY_6_MESSAGE = "번호는 6개만 지정 가능 합니다.";
    private static final String LOTTO_DUPLICATE_MESSAGE = "번호는 중복될 수 없습니다.";
    private static final int LOTTO_NUMBER_SIZE = 6;

    private final List<LottoNumber> value;

    public LottoNumbers(final List<LottoNumber> value) {
        validateSize(value);
        validateDuplicate(value);
        Collections.sort(value);
        this.value = new ArrayList<>(value);
    }

    public static LottoNumbers of(List<Integer> number) {
        List<LottoNumber> numbers = number.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
        return new LottoNumbers(numbers);
    }

    public LottoNumbers(LottoNumbers copy) {
        this.value = new ArrayList<>(copy.value);
    }

    public long getMatchNumberCount(LottoNumber lottoNumber) {
        return this.value.stream()
                .filter(x -> x.equals(lottoNumber))
                .count();
    }

    private void validateSize(List<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new ValidLottoException(LOTTO_VALID_ONLY_6_MESSAGE);
        }
    }

    private void validateDuplicate(List<LottoNumber> numbers) {
        Set<LottoNumber> duplicate = new HashSet<>(numbers);
        if (numbers.size() != duplicate.size()) {
            throw new ValidLottoException(LOTTO_DUPLICATE_MESSAGE);
        }
    }

    public List<LottoNumber> getValue() {
        return Collections.unmodifiableList(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
