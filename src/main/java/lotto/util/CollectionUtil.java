package lotto.util;

import java.util.List;
import java.util.stream.Collectors;

public class CollectionUtil {

    public static List<Integer> toIntegers(List<String> strings) {
        return strings.stream().map(Integer::valueOf).collect(Collectors.toList());
    }
}
