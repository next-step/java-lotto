package lotto.model;

import java.util.List;
import java.util.Set;

public class WinningStatistic {

    public static int getEqualCount(Set<Integer> source, Set<Integer> target) {
        return (int) source.stream()
                .filter( el -> target.contains(el))
                .count();
    }

    public static boolean isContains(Set<Integer> source, Integer number){
        return source.contains(number);
    }
}
