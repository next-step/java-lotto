package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {

    public List<String> split(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("입력값이 비어있습니다");
        }

        return Arrays.stream(input.split(" ")).collect(Collectors.toList());
    }
}
