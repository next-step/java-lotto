package step2.lotto.utility;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class NumberSplitter {

    private static final String DEFAULT_DELIMITER = ",";

    public static Set<Integer> splitNumber(final String inputWinNumber) {
        return Arrays.stream(inputWinNumber.split(DEFAULT_DELIMITER))
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(Collectors.toSet());
    }

}
