package lotto.utils;

import lotto.vo.LotteryNumber;
import lotto.vo.Money;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ConstTest {
    public static final Money moneyMillion = new Money(10_000);
    public static Money moneyThousand = new Money(1_000);

    private static final Set<Integer> lottoNumberManual1 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
    public static final LotteryNumber lottery1 = new LotteryNumber(lottoNumberManual1);
    private static final Set<Integer> lottoNumberManual2 = new HashSet<>(Arrays.asList(2, 10, 28, 34, 35, 44));
    public static final LotteryNumber lottery2 = new LotteryNumber(lottoNumberManual2);
    public static final LotteryNumber lotteryForth = new LotteryNumber( new HashSet<>(Arrays.asList(1, 2, 3, 20, 30, 40)));
}