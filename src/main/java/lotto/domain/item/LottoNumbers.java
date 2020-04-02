package lotto.domain.item;

import lotto.exception.ValidLottoException;

import java.util.*;
import java.util.stream.Collectors;

public class LottoNumbers {

    private static final String LOTTO_VALID_ONLY_6 = "번호는 6개만 지정 가능 합니다.";
    private static final int LOTTO_NUMBER_SIZE = 6;

    private final List<LottoNumber> value;

    public LottoNumbers(List<LottoNumber> value) {
        validateSize(value);
        validateDuplicate(value);
        Collections.sort(value);
        this.value = Collections.unmodifiableList(new ArrayList<>(value));
    }

    public static LottoNumbers of(List<Integer> number) {
        List<LottoNumber> numbers = number.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
        return new LottoNumbers(numbers);
    }

    public static LottoNumbers createLottoNumbersUseInteger(List<Integer> value) {
        List<LottoNumber> lottoNumberBulk = LottoNumber.createLottoNumberBulk(value);
        return new LottoNumbers(lottoNumberBulk);
    }

    public LottoNumbers(LottoNumbers copy) {
        this.value = Collections.unmodifiableList(new ArrayList<>(copy.value));
    }

    private static void validateSize(List<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new ValidLottoException(LOTTO_VALID_ONLY_6);
        }
    }

    private static void validateDuplicate(List<LottoNumber> numbers) {
        Set<LottoNumber> duplicate = new HashSet<>(numbers);
        if (numbers.size() != duplicate.size()) {
            throw new ValidLottoException("번호는 중복될 수 없습니다.");
        }
    }

    public List<LottoNumber> getValue() {
        return new ArrayList<>(value);
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
