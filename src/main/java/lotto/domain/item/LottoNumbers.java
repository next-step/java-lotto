package lotto.domain.item;

import lotto.exception.ValidLottoException;

import java.util.*;

public class LottoNumbers {

    private static final String LOTTO_VALID_ONLY_6 = "번호는 6개만 지정 가능 합니다.";
    private static final int LOTTO_NUMBER_SIZE = 6;

    private final List<LottoNumber> numbers;

    public LottoNumbers(List<LottoNumber> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        this.numbers = Collections.unmodifiableList(new ArrayList<>(numbers));
    }

    private void validateSize(List<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new ValidLottoException(LOTTO_VALID_ONLY_6);
        }
    }

    private void validateDuplicate(List<LottoNumber> numbers) {
        Set<LottoNumber> duplicate = new HashSet<>(numbers);
        if (numbers.size() != duplicate.size()) {
            throw new ValidLottoException("번호는 중복될 수 없습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
