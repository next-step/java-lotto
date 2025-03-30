package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbersParser {
    public static final String LOTTO_NUM_DELIMITER = ",";

    public static List<Integer> parse(String input) {
        return Arrays.stream(input.split(LOTTO_NUM_DELIMITER))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
