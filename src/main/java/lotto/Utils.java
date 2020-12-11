package lotto;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {

    public static <T> List<T> getIntersection(List<T> aList, List<T> bList) {
        HashMap<T, Integer> cardinalityMap = new HashMap<>();

        for (T a : aList) {
            cardinalityMap.put(a, 0);
        }

        for (T b : bList) {
            cardinalityMap.computeIfPresent(b, (k, cardinality) -> cardinality + 1);
        }

        return cardinalityMap.entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());
    }

    public static <T> boolean isUnique(List<T> lst) {
        return new HashSet<>(lst).size() == lst.size();
    }

    public static int defaultIfNull(Integer v) {
        return v == null ? 0 : v;
    }

}
