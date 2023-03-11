package Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    private final List<Integer> lottoNumbers;

    protected Lotto(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto createLotto() {
        List<Integer> lottoNumbers = makeLottoNumbers();
        return new Lotto(lottoNumbers);
    }

    public static List<Integer> makeLottoNumbers() {
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < 45; i++) {
            numbers.add(i);
        }

        Collections.shuffle(numbers);
        return numbers.subList(0, 6);
    }

    public List<Integer> getLottoNumbers() {
        return this.lottoNumbers;
    }

}
