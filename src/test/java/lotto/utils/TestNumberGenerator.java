package lotto.utils;

import lotto.domain.NumberGenerator;

import java.util.List;

public class TestNumberGenerator implements NumberGenerator {

    private final List<Integer> testNumbers;

    public TestNumberGenerator(List<Integer> testNumbers) {
        this.testNumbers = testNumbers;
    }

    @Override
    public List<Integer> generateNumbers() {
        return testNumbers;
    }
}
