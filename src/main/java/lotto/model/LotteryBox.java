package lotto.model;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LotteryBox {
    public static final List<LotteryNumber> numbers = IntStream.rangeClosed(1, 45)
            .mapToObj(n -> new LotteryNumber(n))
            .collect(Collectors.toList());

    public static void shuffleBox() {
        Collections.shuffle(LotteryBox.numbers);
    }

    public static TreeSet<LotteryNumber> createLottery() {
        LotteryBox.shuffleBox();
        TreeSet<LotteryNumber> list = new TreeSet<>();
        for (int i = 1; i <= 6; i++) {
            list.add(LotteryBox.numbers.get(i));
        }
        return list;
    }
}
