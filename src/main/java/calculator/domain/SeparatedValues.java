package calculator.domain;

import java.util.List;
import java.util.Objects;

public class SeparatedValues {
    private List<Integer> separatedValues;

    public SeparatedValues(List<Integer> separatedValues) {
        this.separatedValues = separatedValues;
    }

    public void checkMinusValues() {
        separatedValues.forEach(separatedValue -> {
            if (separatedValue < 0) {
                throw new RuntimeException("입력값으로 음수는 전달할 수 없습니다.");
            }
        });
    }

    public int calculateSum() {
        return separatedValues.stream()
                .mapToInt(value -> value).sum();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SeparatedValues that = (SeparatedValues) o;
        return Objects.equals(separatedValues, that.separatedValues);
    }

    @Override
    public int hashCode() {
        return Objects.hash(separatedValues);
    }
}
