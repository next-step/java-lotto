package Calculator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AddNumber {
    private final List<NonNegativeNumber> numberList;

    private AddNumber(String[] numberArray) {
        this.numberList = Stream.of(numberArray)
                .map(Integer::parseInt)
                .map(NonNegativeNumber::new)
                .collect(Collectors.toList());
    }

    public static AddNumber newInstance (String[] numberArray) {
        return new AddNumber(numberArray);
    }

    public int sum() {
        return this.numberList
                .stream()
                .reduce(NonNegativeNumber::add)
                .orElse(NonNegativeNumber.ZERO)
                .getNumber();
    }
}
