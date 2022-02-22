package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private static final int LOTTO_SIZE = 6;
    private static final int STANDARD_NUMBER = 12;
    private static final String DUPLICATE_NUMBER = "복권에 중복된 숫자가 존재합니다.";
    private static final String INVALID_SIZE = "복권의 숫자 개수가 유효하지 않습니다.";

    private final List<LottoNumber> lottoNumbers;

    private Lotto(final List<LottoNumber> numbers) {
        validateNumbersSize(numbers);
        validateDuplicateNumber(numbers);
        this.lottoNumbers = new ArrayList<>(numbers);
    }

    public static Lotto of(final List<LottoNumber> numbers) {
        return new Lotto(numbers);
    }

    private void validateDuplicateNumber(final List<LottoNumber> numbers) {
        HashSet<LottoNumber> deDuplication = new HashSet<>(numbers);
        if (numbers.size() != deDuplication.size()) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER);
        }
    }

    private void validateNumbersSize(final List<LottoNumber> numbers) {
        if (numbers == null || numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(INVALID_SIZE);
        }
    }

    public int countSameNumber(Lotto otherNumbers) {
        Set<LottoNumber> lottoDuplicate = new HashSet<>(otherNumbers.getLottoNumbers());
        lottoDuplicate.addAll(lottoNumbers);
        return STANDARD_NUMBER - lottoDuplicate.size();
    }

    public int size() {
        return lottoNumbers.size();
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    public List<LottoNumber> getLottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Lotto)) {
            return false;
        }
        List<LottoNumber> that = ((Lotto) o).getLottoNumbers();
        Set<LottoNumber> duplicate = new HashSet<>(lottoNumbers);
        duplicate.addAll(that);
        return duplicate.size() == lottoNumbers.size();
    }

    @Override
    public int hashCode() {
        int hash = 0;
        for (LottoNumber lottoNumber : lottoNumbers) {
            hash += lottoNumber.getValue() * 31;
        }
        return hash;
    }
}
