package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class WinNumber {

    private final LottoNumbers winNumbers;

    public WinNumber(String[] numbers) {
        List<LottoNumber> toLottoNumber = Arrays.stream(numbers)
            .map(Integer::parseInt)
            .map(LottoNumber::new)
            .collect(Collectors.toList());

        this.winNumbers = new LottoNumbers(toLottoNumber);
    }

    public WinNumber(Integer... numbers) {
        this(new LottoNumbers(numbers));
    }

    public WinNumber(LottoNumbers winNumbers) {
        this.winNumbers = winNumbers;
    }

    public int matchCount(LottoNumbers lottoNumbers) {
        return lottoNumbers.calculateMatchCount(winNumbers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof WinNumber))
            return false;
        WinNumber winNumber = (WinNumber)o;
        return Objects.equals(winNumbers, winNumber.winNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(winNumbers);
    }
}
