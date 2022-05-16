package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LotteryBox {
    public static final Set<LotteryNumber> numbers = IntStream.rangeClosed(1, 45).mapToObj(n -> new LotteryNumber(n)).collect(Collectors.toSet());

    public static List<LotteryNumber> shuffleBox() {
        List<LotteryNumber> lotteryNumbers = new ArrayList<>(LotteryBox.numbers);
        Collections.shuffle(lotteryNumbers);
        return lotteryNumbers;
    }

    public static List<LotteryNumber> createLottery() {
        List<LotteryNumber> shuffledLotteryNumbers = LotteryBox.shuffleBox();
        List<LotteryNumber> list = new ArrayList();
        for (int i = 1; i <= 6; i++) {
            list.add(shuffledLotteryNumbers.get(i));
        }
        return list;
    }

    public static List<LotteryNumber> sort(List<LotteryNumber> list) {
        Collections.sort(list);
        return list;
    }
}
