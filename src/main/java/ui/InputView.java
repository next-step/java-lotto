package ui;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    public List<Integer> extractNumbers(String input) {
        return Arrays.stream(input.split("[,:]"))
                .map(Integer::parseInt)
                .map(this::numberValidation)
                .collect(Collectors.toList());
    }

    private Integer numberValidation(Integer number) {
        if (number < 0) throw new IllegalArgumentException();
        return number;
    }
}
