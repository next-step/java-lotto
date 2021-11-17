package calcalator.model;

import java.util.List;

public class Numbers {
    private final List<Number> numbers;

    public Numbers(List<Number> numbers) {
        this.numbers = numbers;
    }

    public Number sum() {
        Number result = new Number();
        for (Number number : numbers) {
            result.plus(number);
        }
        return result;
    }

}
