package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoCalculator {

    private static final int STANDARD_NUMBER = 12;
    private static final LottoCalculator INSTANCE = new LottoCalculator();

    private LottoCalculator() {}

    public int countLotteryNumber(final List<Integer> lotteryNumbers, List<Integer> userNumbers) {
        Set<Integer> set = new HashSet<>(lotteryNumbers);
        set.addAll(userNumbers);
        return STANDARD_NUMBER - set.size();
    }

    public static LottoCalculator getInstance() {
        return INSTANCE;
    }
}