package step2.model;

import java.util.*;

public class Lotto {
    private final List<LottoNumber> lottoNumbers;

    public Lotto(LottoStrategy lottoStrategy) {
        this.lottoNumbers = lottoStrategy.getNumbers();
    }

    public Lotto(List<Integer> numbers) {
        lottoNumbers = new ArrayList<>();

        for (int number : numbers) {
            lottoNumbers.add(new LottoNumber(number));
        }
    }

    public List<Integer> getLottoNumbers() {
        List<Integer> numbers = new ArrayList<>();

        for (LottoNumber lottoNumber : lottoNumbers) {
            numbers.add(lottoNumber.getLottoNumber());
        }
        return numbers;
    }

}
