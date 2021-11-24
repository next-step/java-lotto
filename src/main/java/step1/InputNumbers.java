package step1;

import java.util.List;
import java.util.Objects;

public class InputNumbers {
    List<InputNumber> inputNumbers;

    public InputNumbers(List<InputNumber> inputNumber) {
        this.inputNumbers = inputNumber;
    }

    public List<InputNumber> getList() {
        return inputNumbers;
    }

    public InputNumber sum() {
        return new InputNumber(
                inputNumbers.stream()
                        .mapToInt(InputNumber::getNumber)
                        .sum()
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InputNumbers that = (InputNumbers) o;
        return Objects.equals(inputNumbers, that.inputNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inputNumbers);
    }
}
