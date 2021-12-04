package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Numbers {

    private static final String NUMBER_DELIMITER = ", ";

    private final List<Number> numbers;

    public Numbers(String numbersInput) {
        this.numbers = createNumbers(numbersInput);
    }

    private List<Number> createNumbers(String numbersInput) {
        String[] strNumberArr = numbersInput.split(NUMBER_DELIMITER);
        List<Number> numbers = new ArrayList<>();

        for(String strNumber: strNumberArr) {
            numbers.add(new Number(strNumber));
        }

        return numbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Numbers other = (Numbers) o;
        return Objects.equals(numbers, other.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    public List<Number> getNumbers() {
        return numbers;
    }
}
