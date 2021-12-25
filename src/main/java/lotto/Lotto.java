package lotto;

import java.util.List;
import java.util.Objects;

public class Lotto {

    private final Numbers lottoNumbers;

    public Lotto(List<Number> numbers) {
        this(new Numbers(numbers));
    }

    public Lotto(Numbers numbers) {
        this.lottoNumbers = numbers;
    }

    public Lotto(String lottoNumbers) {
        this.lottoNumbers = new Numbers(lottoNumbers);
    }

    public Numbers getLottoNumbers() {
        return lottoNumbers;
    }

    public boolean containsNumber(Number number) {
        return lottoNumbers.contains(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
