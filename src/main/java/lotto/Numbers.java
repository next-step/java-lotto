package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Numbers {

    private static final String NUMBER_DELIMITER = ", ";
    private static final int NO_MATCH_COUNT = 0;
    private static final int YES_MATCH_COUNT = 1;

    private final List<Number> numbers;

    public Numbers(String numbersInput) {
        this.numbers = createNumbers(numbersInput);
    }

    public Numbers(List<Number> numbers) {
        this.numbers = numbers;
    }

    public int countMatch(Numbers others) {
        if (others == null) {
            return NO_MATCH_COUNT;
        }

        int count = 0;

        for(Number number : numbers) {
            count += countMatch(number, others);
        }

        return count;
    }

    private int countMatch(Number number, Numbers others) {
        if (others.contains(number)) {
            return YES_MATCH_COUNT;
        }
        return NO_MATCH_COUNT;
    }

    public List<Number> getNumbers() {
        return new ArrayList<>(numbers);
    }

    private boolean contains(Number number) {
        return numbers.contains(number);
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

}
