package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LotteryBox {
    public static final List<Integer> numbers = IntStream.rangeClosed(1,45).boxed().collect(Collectors.toList());
    public static void shuffleBox() {
        Collections.shuffle(LotteryBox.numbers);
    }
}
