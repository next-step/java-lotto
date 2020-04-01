package calculator;

import java.util.ArrayList;
import java.util.List;

public class PostiveNumbers {
    private final List<PositiveNumber> positiveNumbers;

    public PostiveNumbers(List<PositiveNumber> positiveNumbers) {
        this.positiveNumbers = new ArrayList<>(positiveNumbers);
    }

    public Integer sum() {
        return positiveNumbers.stream()
                .reduce(new PositiveNumber(0), PositiveNumber::sum)
                .getNumber();
    }

    public List<PositiveNumber> getPositiveNumbers() {
        return new ArrayList<>(positiveNumbers);
    }
}
