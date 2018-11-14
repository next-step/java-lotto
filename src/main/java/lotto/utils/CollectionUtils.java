package lotto.utils;

import java.util.ArrayList;
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

    public static List<Integer> merge(List<Integer> list, int... elements) {
        List<Integer> result = new ArrayList<>(list);
        Arrays.stream(elements).forEachOrdered(result::add);
        return result;
    }
}
