package study;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Splitter {
    private static final String SEPARATOR = "[,:]";

    public static List<String> split(String input) {
        String[] inputs = input.split(SEPARATOR);
        return Arrays.stream(inputs)
                .collect(Collectors.toList());
    }
}
