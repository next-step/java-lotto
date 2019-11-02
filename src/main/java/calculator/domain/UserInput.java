package calculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserInput {

    private String input;

    public UserInput(String input) {
        this.input = input;
    }

    public String getInput() {
        return input;
    }

    public List<Integer> getIntegers() {
        String[] split = input.split("[,:]");

        return Arrays.stream(split)
                .map(Integer::new)
                .collect(Collectors.toList());
    }
}
