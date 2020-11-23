package step03.domain;

import java.util.Arrays;
import java.util.stream.Collectors;

public class LottoNumberTokenizer {
    private static String TOKEN = ", ";

    public static Lotto execute(String winningNumbers) {
        return Lotto.of(
                Arrays.stream(winningNumbers.split(TOKEN))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList())
        );
    }

}
