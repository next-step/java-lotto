package lotto.domain;

import java.util.List;

public class Numbers {

    private final List<Integer> rawValues;

    public Numbers(List<Integer> numbers) {
        this.rawValues = numbers;
    }

    public int getSize() {
        return rawValues.size();
    }

    public List<Integer> getRawValues() {
        return rawValues;
    }
}
