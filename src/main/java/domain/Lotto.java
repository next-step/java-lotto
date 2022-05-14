package domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {
    public static int PRICE = 1000;
    private LottoNumbers lottoNumbers;

    public Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return lottoNumbers.equals(lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }

    @Override
    public String toString() {
        List<String> lottoNumbersString = lottoNumbers.toList().stream()
                .map(LottoNumber::toString)
                .collect(Collectors.toList());
        return "[" + String.join(", ", lottoNumbersString) + "]";
    }
}
