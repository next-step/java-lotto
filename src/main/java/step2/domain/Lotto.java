package step2.domain;

import java.util.List;

public class Lotto {

    private final LottoNumber lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {
        this.lottoNumbers = new LottoNumber(lottoNumbers);
    }

    private Lotto() {
        TotalNumbers totalNumbers = new TotalNumbers();
        List<Integer> numbers = totalNumbers.getRandomNumber();
        this.lottoNumbers = new LottoNumber(numbers);
    }

    public static Lotto issue() {
        return new Lotto();
    }

    public List<Integer> getNumbers() {
        return this.lottoNumbers.get();
    }
}

