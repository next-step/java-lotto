package lotto;

import java.util.List;

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

    public int countMatch(Lotto other) {
        return lottoNumbers.countMatch(other.lottoNumbers);
    }

    public Numbers getLottoNumbers() {
        return lottoNumbers;
    }

}
