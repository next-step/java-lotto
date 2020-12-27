package calculator.service;

import calculator.domain.SplitStringDelimiter;
import calculator.domain.Values;

public class StringCalculator {

    private final SplitStringDelimiter splitStringDelimiter = new SplitStringDelimiter();
    private final Values values;

    public StringCalculator(String inputValue) {
        values = new Values(splitStringDelimiter.splitString(inputValue));
    }

    public int sumNumbers() {
        return values.sum();
    }
}
