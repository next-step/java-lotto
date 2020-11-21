package step03.domain;

import java.util.Arrays;
import java.util.stream.Collectors;

public class WinningNumberTokenizer {
    private static String TOKEN = ", ";

    public static Lotto execute(String winningNumbers) {
        return Lotto.intOf(
                Arrays.stream(winningNumbers.split(TOKEN))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList())
        );
    }

}
