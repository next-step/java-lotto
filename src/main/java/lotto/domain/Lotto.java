package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public abstract class Lotto {
    protected static final int LOTTO_NUMBER_COUNT = 6;

    protected final Set<LottoNumber> lottoNumbers;

    private Lotto(Set<LottoNumber> numbers) {
        lottoNumbers = Collections.unmodifiableSet(new TreeSet<>(numbers));
    }

    protected Lotto(List<LottoNumber> numbers) {
       this(convertToSet(numbers));
    }

    private static Set<LottoNumber> convertToSet(List<LottoNumber> numbers) {
        validateInputs(numbers);

        Set<LottoNumber> lottoNumbers = new TreeSet<>();
        for (LottoNumber number : numbers) {
            addUniqueLottoNumber(number, lottoNumbers);
        }

        return lottoNumbers;
    }

    public int countNumberMatchCount(Set<LottoNumber> numbers) {
        return (int) lottoNumbers.stream()
                .filter(numbers::contains)
                .count();
    }

    public boolean isNumberMatched(LottoNumber number) {
        return lottoNumbers.contains(number);
    }

    protected static void addUniqueLottoNumber(LottoNumber lottoNumber, Set<LottoNumber> lottoNumbers) {
        if (isNotUniqueLottoNumber(lottoNumber, lottoNumbers)) {
            throw new IllegalArgumentException("중복되는 번호가 있습니다. 중복된 번호: " + lottoNumber);
        }
    }

    protected static boolean isNotUniqueLottoNumber(LottoNumber lottoNumber, Set<LottoNumber> lottoNumbers) {
        return !lottoNumbers.add(lottoNumber);
    }

    protected static void validateInputs(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER_COUNT) {
            String messageFormat = "로또는 %d개의 숫자로 구성되어 있습니다. 입력된 숫자 수: %d";
            throw new IllegalArgumentException(String.format(messageFormat, LOTTO_NUMBER_COUNT, lottoNumbers.size()));
        }
    }

    public Set<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    public abstract LottoType getLottoType();
}
