package my.project.lotto.domain;

import java.util.*;

/**
 * Created : 2020-11-23 오후 12:10
 * Developer : Seo
 */
public class Lotto {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    public static final int NUMBER_SIZE = 6;
    private final SortedSet<Integer> selected;
    private static final List<Integer> numbers = new ArrayList<>();

    static {
        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
            numbers.add(i);
        }
    }

    public Lotto() {
        Collections.shuffle(numbers);
        selected = new TreeSet<>();
    }

    public SortedSet<Integer> generate() {
        for (int i = 0; i < NUMBER_SIZE; i++) {
            selected.add(numbers.get(i));
        }
        return selected;
    }

//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        sb.append("[");
//        for (Integer i : result) {
//            sb.append(", ");
//            sb.append(i);
//        }
//        sb.append("]");
//        return sb.toString().replaceFirst(", ", "");
//    }
}
