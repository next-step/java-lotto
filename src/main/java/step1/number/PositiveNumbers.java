package step1.number;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public final class PositiveNumbers {

    private final List<PositiveNumber> positiveNumbers;

    public PositiveNumbers(String[] data) {
        this(convertStringArrayToNumberList(data));
    }

    public PositiveNumbers(List<PositiveNumber> positiveNumbers) {
        if (isNull(positiveNumbers)) {
            throw new IllegalArgumentException("null 값을 입력했습니다.");
        }
        this.positiveNumbers = positiveNumbers;
    }

    private static final List<PositiveNumber> convertStringArrayToNumberList(String[] data) {
        return Arrays.stream(data)
                .mapToInt(Integer::parseInt)
                .mapToObj(PositiveNumber::valueOf)
                .collect(Collectors.toList());
    }

    private final boolean isNull(List<PositiveNumber> positiveNumbers) {
        return positiveNumbers == null;
    }

    public final int sum() {
        return positiveNumbers.stream()
                .mapToInt(PositiveNumber::getPositiveNumber)
                .sum();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PositiveNumbers positiveNumbers1 = (PositiveNumbers) o;
        return Objects.equals(positiveNumbers, positiveNumbers1.positiveNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(positiveNumbers);
    }
}
