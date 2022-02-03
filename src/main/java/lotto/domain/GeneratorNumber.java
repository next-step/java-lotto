package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GeneratorNumber {

    private final List<Integer> numbers;

    public GeneratorNumber() {
        numbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            numbers.add(i);
        }
    }

    public List<Integer> generateLottoNumbers() {
        Collections.shuffle(this.numbers);
        return this.numbers.subList(0, 6);
    }
}
