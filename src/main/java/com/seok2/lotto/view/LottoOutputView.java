package com.seok2.lotto.view;

import com.seok2.lotto.domain.GameStats;
import com.seok2.lotto.domain.Lotteries;
import com.seok2.lotto.domain.Rank;
import com.seok2.lotto.domain.Profit;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;

public class LottoOutputView {

    private static final String PURCHASE_QUANTITY_MSG = "{0} 개를 구매했습니다.";
    private static final String GAME_STATS_MSG = "{0} - {1}";
    private static final List<Rank> RANK_LIST = Arrays.asList(Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST);

    public static void printPurchaseHistory(Lotteries lotteries) {
        printPurchaseQuantity(lotteries.size());
        printLotteries(lotteries);
    }

    private static void printLotteries(Lotteries lotteries) {
        lotteries.forEach(System.out::println);
        System.out.println();
    }

    private static void printPurchaseQuantity(int size) {
        System.out.println(MessageFormat.format(PURCHASE_QUANTITY_MSG, size));
    }

    public static void printStats(GameStats stats) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("----------");
        RANK_LIST.forEach(rank -> System.out.println(MessageFormat.format(GAME_STATS_MSG, rank, stats.getNumberOfWins(rank))));
        System.out.println();
    }

    public static void printProfit(Profit profit) {
        System.out.println(profit);
    }
}
