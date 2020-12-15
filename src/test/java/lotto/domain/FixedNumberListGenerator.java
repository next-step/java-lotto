package lotto.domain;

import java.util.*;

public class FixedNumberListGenerator implements NumberListGenerator {

    private final Queue<Set<Integer>> numberList;

    public FixedNumberListGenerator() {
        numberList = new LinkedList<>();
        numberList.add(new HashSet<>(Arrays.asList(8, 21, 23, 41, 42, 43)));
        numberList.add(new HashSet<>(Arrays.asList(3, 5, 11, 16, 32, 38)));
        numberList.add(new HashSet<>(Arrays.asList(7, 11, 16, 35, 36, 44)));
        numberList.add(new HashSet<>(Arrays.asList(1, 8, 11, 31, 41, 42)));
        numberList.add(new HashSet<>(Arrays.asList(13, 14, 16, 38, 42, 45)));
        numberList.add(new HashSet<>(Arrays.asList(7, 11, 30, 40, 42, 43)));
        numberList.add(new HashSet<>(Arrays.asList(2, 13, 22, 32, 38, 45)));
        numberList.add(new HashSet<>(Arrays.asList(23, 25, 33, 36, 39, 41)));
        numberList.add(new HashSet<>(Arrays.asList(1, 3, 5, 14, 22, 45)));
        numberList.add(new HashSet<>(Arrays.asList(5, 9, 38, 41, 43, 44)));
        numberList.add(new HashSet<>(Arrays.asList(2, 8, 9, 18, 19, 21)));
        numberList.add(new HashSet<>(Arrays.asList(13, 14, 18, 21, 23, 35)));
        numberList.add(new HashSet<>(Arrays.asList(17, 21, 29, 37, 42, 45)));
        numberList.add(new HashSet<>(Arrays.asList(3, 8, 27, 30, 35, 43)));
    }

    @Override
    public Set<Integer> generate() {
        return numberList.poll();
    }
}
