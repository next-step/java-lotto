package lotto.domain;

import util.Splitter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Number> numbers = new ArrayList<>();

    public Lotto(List<Number> randomNumbers) {
        Collections.sort(randomNumbers);
        numbers.addAll(randomNumbers);
    }

    public Lotto(String manualLottoNumbers) {
        numbers.addAll(Splitter.SplitStringNumbers(manualLottoNumbers));
    }

    public List<Number> getNumbers() {
        return numbers;
    }

    public Number getIndexNumber(int no) {
        return numbers.get(no);
    }

    @Override
    public String toString() {
        return numbers.toString() + System.lineSeparator();
    }
}
