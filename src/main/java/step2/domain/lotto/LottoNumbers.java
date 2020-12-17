package step2.domain.lotto;

import java.util.List;

import static java.util.Collections.*;
import static java.util.stream.Collectors.*;

public final class LottoNumbers {
    private final List<LottoNumber> lottoNumbers;
    private static final long NUMBER_LENGTH = 6L;

    public LottoNumbers(List<Integer> numbers) {
        checkLottoNumbersLength(numbers);
        this.lottoNumbers = unmodifiableList(changeNumbersToLottoNumbers(numbers));
    }

    private void checkLottoNumbersLength(List<Integer> numbers) {
        long lottoNumberLength = numbers.stream()
                .distinct()
                .count();
        if (lottoNumberLength != NUMBER_LENGTH) {
            throw new IllegalArgumentException("중복 없는 6개의 숫자가 필요합니다");
        }
    }

    private List<LottoNumber> changeNumbersToLottoNumbers(List<Integer> lottoNumbers) {
        return lottoNumbers.stream()
                .map(LottoNumber::new)
                .collect(toList());
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers.stream()
                .map(LottoNumber::getNumber)
                .collect(toList());
    }

    public long getEqualNumberCount(List<Integer> targetNumbers) {
        return lottoNumbers.stream()
                .map(LottoNumber::getNumber)
                .filter(targetNumbers::contains)
                .count();
    }
}
