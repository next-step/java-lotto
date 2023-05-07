package lotto.model;

import java.util.List;

public class WinningStatistic {

    public static int getEqualCount(List<Integer> source, List<Integer> target) {
        return (int) source.stream()
                .filter( el -> target.contains(el))
                .count();
    }

    public static boolean isContains(List<Integer> source, Integer number){
        return source.contains(number);
    }
}
