package step1.domain;

import java.util.ArrayList;
import java.util.List;

public class Numbers {
    private List<Number> numbers;

    public Numbers(List<Integer> numberList) {
        List<Number> numbers = new ArrayList<Number>();
        for (Integer number : numberList) {
            numbers.add(new Number(number));
        }
        this.numbers = numbers;
    }

    public Number add() {
        return numbers.stream().reduce((x, y) -> x.add(y)).get();
    }
}
