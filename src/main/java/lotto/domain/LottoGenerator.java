package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {

    private List<Integer> numbers;

    public LottoGenerator() {
        numbers = new ArrayList<>();

        setNumber();
        Collections.shuffle(numbers);
    }

    public void setNumber() {
        for (int i = 1; i <= 45; i++) {
            numbers.add(i);
        }
    }
}
