package lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LotteryBox {
    public final static List<Integer> numbers = IntStream.rangeClosed(1,45).boxed().collect(Collectors.toList());
}
