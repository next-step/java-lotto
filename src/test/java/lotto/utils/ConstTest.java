package lotto.utils;

import lotto.vo.LotteryNumber;
import lotto.vo.LotteryNumbers;
import lotto.vo.Money;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ConstTest {
    public static final Money MONEY_MILLION = new Money(10_000);
    public static final Money MONEY_5_THOUSAND = new Money(5_000);
    public static Money MONEY_THOUSAND = new Money(1_000);

    private static final Set<Integer> NUMBER_MANUAL = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
    public static final LotteryNumber LOTTERY_NUMBER_DEFAULT = new LotteryNumber(NUMBER_MANUAL);
    public static final LotteryNumber LOTTERY_ACCORDANCE_TWO = new LotteryNumber( new HashSet<>(Arrays.asList(1, 2, 12, 20, 30, 40)));
    public static final LotteryNumber LOTTERY_ACCORDANCE_THREE = new LotteryNumber( new HashSet<>(Arrays.asList(1, 2, 3, 20, 30, 40)));
    public static final LotteryNumber LOTTERY_ACCORDANCE_FIVE_HAS_BONUS = new LotteryNumber(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 40)), 6);

    public static final LotteryNumbers LOTTERY_NUMBERS = new LotteryNumbers(Arrays.asList(ConstTest.LOTTERY_NUMBER_DEFAULT, ConstTest.LOTTERY_ACCORDANCE_THREE));
}