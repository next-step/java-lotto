package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Number> numbers = new ArrayList<>();


    public Lotto(List<Number> randomNumbers) {
        Collections.sort(randomNumbers);
        numbers.addAll(randomNumbers);
    }

    public List<Number> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString() + System.lineSeparator();
    }
}
