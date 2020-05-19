package ui;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    public List<Integer> extractNumbers(String input) {
        return Arrays.stream(input.split("[,:]"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
