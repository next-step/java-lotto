package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LotteryBox {
    public static final List<Integer> numbers = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList());

    public static void shuffleBox() {
        Collections.shuffle(LotteryBox.numbers);
    }

    public static List<Integer> findSixNumbers() {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            list.add(LotteryBox.numbers.get(i));
        }
        return sort(list);
    }

    public static List<Integer> sort(List<Integer> list) {
        Collections.sort(list);
        return list;
    }
}
