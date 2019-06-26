package lotto.util;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {

    public static List<Integer> generate() {
        List<Integer> lotteryNumbers = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList());
        Collections.shuffle(lotteryNumbers);
        Collections.sort(lotteryNumbers);
        return lotteryNumbers.subList(0,6);
    }
}
