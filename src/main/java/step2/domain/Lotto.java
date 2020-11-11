package step2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> lottoNumbers;

    public Lotto() {
        lottoNumbers = new ArrayList<>();
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i < 46; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        for (int i = 0; i < 6; i++) {
            lottoNumbers.add(numbers.get(i));
        }
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}
