package ui;

import domain.Number;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    public List<Number> extractNumbers(String input) {
        return Arrays.stream(input.split("[,:]"))
                .map(Number::new)
                .collect(Collectors.toList());
    }
}
