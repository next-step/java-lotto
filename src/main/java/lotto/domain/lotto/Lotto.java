package lotto.domain.lotto;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers = NumberGenerator.generateBasicNumber(1, 45);
    private List<Integer> lottoNumber;

    private Lotto() {
        this.lottoNumber = generateLottoNumber();
    }

    public static Lotto create() {
        return new Lotto();
    }

    public List<Integer> getLottoNumber() {
        return this.lottoNumber;
    }

    public List<Integer> generateLottoNumber() {
        Collections.shuffle(numbers);
        List<Integer> lottoNumber = numbers.subList(0, 6);
        Collections.sort(lottoNumber);
        return lottoNumber;
    }

    @Override
    public String toString() {
        return String.valueOf(lottoNumber);
    }
}
