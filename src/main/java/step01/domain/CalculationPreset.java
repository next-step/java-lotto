package step01.domain;

import java.util.List;
import java.util.Objects;

public class CalculationPreset {

    private final List<Integer> numbers;
    private final List<Operator> operations;

    public CalculationPreset(List<Integer> numbers, List<Operator> operations) {
        validateNumbersAndOperationsSize(numbers, operations);
        this.numbers = numbers;
        this.operations = operations;
    }

    public List<Integer> getIntegers() {
        return numbers;
    }

    public List<Operator> getOperations() {
        return operations;
    }

    private void validateNumbersAndOperationsSize(List<Integer> numbers, List<Operator> operations) {
        if (numbers.size() != operations.size() + 1) {
            throw new IllegalArgumentException("연산자의 개수는 숫자의 개수보다 하나가 적어야합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CalculationPreset)) {
            return false;
        }

        CalculationPreset that = (CalculationPreset) o;

        if (!Objects.equals(numbers, that.numbers)) {
            return false;
        }
        return Objects.equals(operations, that.operations);
    }

    @Override
    public int hashCode() {
        int result = numbers != null ? numbers.hashCode() : 0;
        result = 31 * result + (operations != null ? operations.hashCode() : 0);
        return result;
    }
}

