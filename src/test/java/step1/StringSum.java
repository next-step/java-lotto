package step1;

import java.util.Arrays;

public class StringSum {

    public Result sum(String input) {
        String[] split = input.split("[,:]");
        Integer sum = Arrays.stream(split)
            .map(Integer::parseInt)
            .reduce(0, Integer::sum);
        return new Result(sum);
    }
}
