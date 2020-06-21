package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class ListConverter {

    private ListConverter() {}

    public static List<Integer> convertCommaStringToNumberList(final String commaString) {
        return Arrays.stream(commaString.split(","))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }
}
