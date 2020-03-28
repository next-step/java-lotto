package calculator;

import java.util.List;

public class PostiveNumbers {
    private final List<PositiveNumber> positiveNumbers;

    public PostiveNumbers(TextToNumber textToNumber) {
        this.positiveNumbers = textToNumber.getPositiveNumbers();
    }

    public Integer sum() {
        return positiveNumbers.stream()
                .reduce(new PositiveNumber(0), PositiveNumber::sum)
                .getNumber();
    }
}
