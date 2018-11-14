package lotto.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CollectionUtils {

    private CollectionUtils() {

    }

    public static List<Integer> convert(String[] texts) {
        return Arrays.asList(texts).stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
