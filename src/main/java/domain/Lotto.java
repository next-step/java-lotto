package domain;

import java.util.Collections;
import java.util.List;

public class Lotto {

    public static final int LOTTO_NUMBER_BOUND = 45;
    private static final int REQUIRED_NUMBER_COUNT = 6;

    private List<Integer> lottoNumbers;

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    public Lotto auto() {

        List<Integer> numbers = new Numbers(LOTTO_NUMBER_BOUND).getNumbers();

        Collections.shuffle(numbers);

        List<Integer> lottoNumbers = numbers.subList(0, REQUIRED_NUMBER_COUNT);

        Collections.sort(lottoNumbers);

        this.lottoNumbers = lottoNumbers;

        return this;
    }
}
