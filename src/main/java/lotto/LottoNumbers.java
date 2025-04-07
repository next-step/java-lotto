package lotto;

import java.util.Arrays;
import java.util.Objects;
import java.util.Set;

public class LottoNumbers {
    private final Set<LottoNumber> lottoNumbers;

    public LottoNumbers(int[] numbers) {
        checkLottoNumberSize(numbers);
        lottoNumbers = Set.of(
                Arrays.stream(numbers)
                        .mapToObj(LottoNumber::new)
                        .toArray(LottoNumber[]::new)
        );
    }

    private void checkLottoNumberSize(int[] numbers) {
        if (numbers.length != 6) {
            throw new IllegalArgumentException("로또는 총 6개의 숫자로 구성되어 있습니다.");
        }
    }

    public int[] getLottoNumbers() {
        return lottoNumbers.stream()
                .map(LottoNumber::getNumber)
                .mapToInt(Integer::intValue)
                .sorted()
                .toArray();
    }

    public int getContainsCount(LottoNumbers numbers) {
        return (int) numbers.lottoNumbers
                .stream()
                .filter(this::contains)
                .count();
    }

    public boolean contains(LottoNumber number) {
        return lottoNumbers.contains(number);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(lottoNumbers);
    }
}
