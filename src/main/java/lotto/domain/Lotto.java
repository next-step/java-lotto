package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    private static final int LOTTO_SIZE = 6;
    private static final int STANDARD_NUMBER = 12;
    private static final String DUPLICATE_NUMBER = "복권에 중복된 숫자가 존재합니다.";
    private static final String INVALID_SIZE = "복권의 숫자 개수가 유효하지 않습니다.";

    private final List<LottoNumber> numbers;

    public Lotto(final List<LottoNumber> numbers){
        validateNumbersSize(numbers);
        validateDuplicateNumber(numbers);
        this.numbers = numbers;
    }

    public static Lotto of(final List<Integer> numbers) {
        List<LottoNumber> lottoNumbers = numbers.stream()
            .map(LottoNumber::from)
            .collect(Collectors.toList());
        return new Lotto(lottoNumbers);
    }

    private void validateDuplicateNumber(final List<LottoNumber> numbers) {
        HashSet<LottoNumber> lottoDuplicate = new HashSet<>(numbers);
        if (numbers.size() != lottoDuplicate.size()) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER);
        }
    }

    private void validateNumbersSize(final List<LottoNumber> numbers) {
        if (numbers == null || numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(INVALID_SIZE);
        }
    }

    public int countSameNumber(Lotto otherNumbers) {
        Set<LottoNumber> lottoDuplicate = new HashSet<>(otherNumbers.getNumbers());
        lottoDuplicate.addAll(numbers);
        return STANDARD_NUMBER - lottoDuplicate.size();
    }

    public int size() {
        return numbers.size();
    }

    public boolean contains(LottoNumber lottoNumber) {
        return numbers.contains(lottoNumber);
    }

    public List<LottoNumber> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Lotto)) {
            return false;
        }
        List<LottoNumber> that = ((Lotto) o).getNumbers();
        Set<LottoNumber> duplicate = new HashSet<>(numbers);
        duplicate.addAll(that);
        return duplicate.size() == numbers.size();
    }

    @Override
    public int hashCode() {
        int hash = 0;
        for (LottoNumber lottoNumber : numbers) {
            hash += lottoNumber.getValue() * 31;
        }
        return hash;
    }
}
