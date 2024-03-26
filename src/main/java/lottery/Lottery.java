package lottery;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottery {

    public static int buy(int amountMoney) {
        return amountMoney / 1000;
    }

    public static List<Integer> dispense() {
        List<Integer> allNumbers = new ArrayList<>();
        for (int number = 1; number <= 45; number++)
            allNumbers.add(number);
        Collections.shuffle(allNumbers);

        List<Integer> lotteryNumbers = allNumbers.subList(0, 6);
        Collections.sort(lotteryNumbers);
        return lotteryNumbers;
    }

    public static Long matchCount(List<Integer> winNumbers,
                                  List<Integer> lotteryNumbers) {
        return lotteryNumbers.stream()
                .filter(winNumbers::contains)
                .count();
    }

    public static int prize(Long matchCount) {
//        3개 일치 (5000원)
        if(matchCount.equals(3L))
            return 5000;
//        4개 일치 (50000원)
        if(matchCount.equals(4L))
            return 50000;
//        5개 일치 (1500000원)
        if(matchCount.equals(5L))
            return 1500000;
//        6개 일치 (2000000000원)
        if(matchCount.equals(6L))
            return 2000000000;
        return 0;
    }

    public static BigDecimal profitRate(int totalPrize,
                                        int totalMoneySpent) {
        BigDecimal spent = BigDecimal.valueOf(totalMoneySpent);
        BigDecimal profit = BigDecimal.valueOf(totalPrize);
        return profit.divide(spent, 2, RoundingMode.DOWN);
    }
}
