package calculator.input;

import calculator.operator.Operator;

import java.util.List;
import java.util.stream.Collectors;

public class InputIntegers {

    public static final String NUMBER_REGEX = "[0-9]+";
    private final List<Integer> integers;

    public InputIntegers(List<Integer> integers) {
        this.integers = integers;
    }

    public static InputIntegers from(InputStrings inputStrings) {
        List<Integer> result = inputStrings.getStream()
                .filter(str -> str.matches(NUMBER_REGEX))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return new InputIntegers(result);
    }

    public void executeOperator(Operator operator) {
        int result = operator.applyAsInt(integers.get(0), integers.get(1));
        replaceResult(result);
    }

    public Integer getResult() {
        return integers.get(0);
    }

    public void replaceResult(int result) {
        integers.set(0, result);
        integers.remove(1);
    }

    public List<Integer> getIntegers() {
        return integers;
    }
}
