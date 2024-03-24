package lotto.domain;

import java.util.List;

public class Match {
    public static int getCount(List<Integer> sources, List<Integer> targets) {
        if (sources == null || targets == null) throw new IllegalArgumentException();
        return (int) sources.stream()
                .filter(targets::contains)
                .count();
    }

    public static boolean getCount(List<Integer> sources, Integer bonusNumber) {
        if (sources == null || bonusNumber == null) throw new IllegalArgumentException();
        return sources.stream()
                .anyMatch(bonusNumber::equals);
    }
}
