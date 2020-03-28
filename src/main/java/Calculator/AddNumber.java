package Calculator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AddNumber {
    private final List<Integer> numberList;

    private AddNumber(String[] numberArray) {
        this.numberList = Stream.of(numberArray).map(Integer::parseInt).collect(Collectors.toList());
    }

    public static AddNumber newInstance (String[] numberArray) {
        return new AddNumber(numberArray);
    }

    public int add() {
        return this.numberList
                .stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
