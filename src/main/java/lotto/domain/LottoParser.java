package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoParser {

    private static final String DELIMITER = ",";

    static List<Integer> parse(String wonNumbersValue) {

        return Arrays.stream(wonNumbersValue.split(DELIMITER))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
