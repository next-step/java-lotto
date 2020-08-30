package step1;

import java.util.Arrays;

public class ElementAdder {
    private ElementAdder(){}

    static int addAllElements(String inputs[]) {
        int sum = Arrays.stream(inputs)
                .map(Integer::parseInt)
                .reduce(0, Integer::sum);
        return sum;
    }
}
