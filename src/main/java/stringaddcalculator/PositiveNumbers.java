package stringaddcalculator;

import java.util.Collections;
import java.util.List;

public class PositiveNumbers {
    private List<PositiveNumber> positiveNumbers;

    public PositiveNumbers(List<PositiveNumber> positiveNumbers) {
        this.positiveNumbers = Collections.unmodifiableList(positiveNumbers);
    }

    public int sum() {
        int sum = 0;
        for (PositiveNumber positiveNumber : positiveNumbers) {
            sum = positiveNumber.add(sum);
        }
        return sum;
    }
}