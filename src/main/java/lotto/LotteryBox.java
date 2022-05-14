package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LotteryBox {
    public static final List<LotteryNumber> numbers = IntStream.rangeClosed(1, 45).mapToObj(n -> new LotteryNumber(n)).collect(Collectors.toList());

    public static void shuffleBox() {
        Collections.shuffle(LotteryBox.numbers);
    }

    public static List<LotteryNumber> findSixNumbers() {
        LotteryBox.shuffleBox();
        List<LotteryNumber> list = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            list.add(LotteryBox.numbers.get(i));
        }
        return sort(list);
    }

    public static List<LotteryNumber> sort(List<LotteryNumber> list) {
        Collections.sort(list);
        return list;
    }
}
