package study.step1.domain;

import java.util.ArrayList;
import java.util.List;

public class PositiveNumbers {
    private final List<PositiveNumber> positiveNumberList;

    public PositiveNumbers() {
        positiveNumberList = new ArrayList<>();
    }

    public void add(PositiveNumber positiveNumber) {
        positiveNumberList.add(positiveNumber);
    }

    public int sum() {
        return 0;
    }
}
