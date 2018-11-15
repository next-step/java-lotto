package lotto.utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MatchUtils {

    public static int getDuplicateCount(List<Integer> lotto){
        return lotto.size() - (int) lotto.stream()
                .distinct()
                .count();
    }

    public static List<Integer> getDuplicateNums(List<Integer> lotto){
        Set<Integer> allItems = new HashSet<>();
        return lotto.stream()
                .filter(e -> !allItems.add(e))
                .collect(Collectors.toList());
    }

    public static int pluscount(int currentCount){
        return ++currentCount;
    }

    public static boolean isContains(List<Integer> lotto, int bonusNum){
        System.out.println("중복리스트 : " + Arrays.toString(lotto.toArray()));
        return lotto.contains(bonusNum);
    }
}
