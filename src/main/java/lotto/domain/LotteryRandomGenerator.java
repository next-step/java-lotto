package lotto.domain;

import java.util.*;

public class LotteryRandomGenerator {

    private static final List<LotteryNumber> allNumbers;

    static {
        List<LotteryNumber> allLottoNumberList = new ArrayList<>();
        for (int i = LotteryNumber.MIN_VALUE; i <= LotteryNumber.MAX_VALUE; i++) {
            allLottoNumberList.add(LotteryNumber.valueOf(i));
        }
        allNumbers = allLottoNumberList;
    }

    public static Lottery generate(int lotteryNumberSize) {
        Set<LotteryNumber> lotteryNumberTempList = new HashSet<>();
        while (lotteryNumberTempList.size() != lotteryNumberSize) {
            lotteryNumberTempList.add(getRandomLotteryNumber());
        }
        return new Lottery(lotteryNumberTempList);
    }

    private static LotteryNumber getRandomLotteryNumber() {
        Collections.shuffle(allNumbers);
        return allNumbers.get(0);
    }

}
