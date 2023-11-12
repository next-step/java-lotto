package step2.util;

import java.util.List;
import java.util.stream.Collectors;

public class ListUtil {

    public static int numberOfMatches(List<Integer> numbers1, List<Integer> numbers2) {
        return numbers1.stream()
            .filter(number -> isContain(numbers2, number))
            .collect(Collectors.toList())
            .size();
    }

    public static boolean isContain(List<Integer> numbers, int target) {
        return numbers.contains(target);
    }

}
