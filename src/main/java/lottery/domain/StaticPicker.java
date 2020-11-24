package lottery.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StaticPicker implements Picker {
    private final String[] numbers;

    public StaticPicker(String input) {
        numbers = input.split(" *, *");
    }

    @Override
    public List<Integer> pick() {
        return Arrays.stream(numbers)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
