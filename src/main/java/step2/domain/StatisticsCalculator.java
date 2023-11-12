package step2.domain;

import java.util.List;
import java.util.stream.Collectors;

public class StatisticsCalculator {

    public static int numberOfMatches(List<Integer> numbers1, List<Integer> numbers2) {
        return numbers1.stream()
            .filter(number -> numbers2.contains(number))
            .collect(Collectors.toList())
            .size();
    }

    public static boolean isContain(List<Integer> numbers, int target) {
        return numbers.contains(target);
    }

}
