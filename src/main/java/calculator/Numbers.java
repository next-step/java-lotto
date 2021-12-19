package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Numbers {

    private final List<Number> numbers;

    public Numbers(Input input) {
        this.numbers = createNumbers(input);
    }

    public Numbers(Number... numbers) {
        /* For Test */
        this.numbers = new ArrayList<>();
        this.numbers.addAll(Arrays.asList(numbers));
    }


    public Number calculateAddAll() {
        Number result = new Number(0);

        for(Number number : numbers) {
            result = result.plus(number);
        }

        return result;
    }

    private List<Number> createNumbers(Input input) {
        List<Number> numbers = new ArrayList<>();
        String[] inputs = input.getParsedInput();

        for(String strNumber : inputs) {
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
        Numbers numbers1 = (Numbers) o;
        return Objects.equals(numbers, numbers1.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
