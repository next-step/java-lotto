package step02.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Tokenizer {
    private static String TOKEN = ", ";
    public static List<Integer> execute(String winningNumbers) {
        return Arrays.stream(winningNumbers.split(TOKEN))
                .map(Integer::new)
                .collect(Collectors.toList());
    }
}
