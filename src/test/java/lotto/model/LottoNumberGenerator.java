package lotto.model;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoNumberGenerator {
    private final List<LottoNumber> lottoNumbers;

    public static LottoNumberGenerator generate(int[] numbers) {
        List<LottoNumber> numberList = Arrays.stream(numbers)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());

        return new LottoNumberGenerator(numberList);
    }

    private LottoNumberGenerator(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<LottoNumber> lottoNumbers() {
        return this.lottoNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumberGenerator that = (LottoNumberGenerator) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
