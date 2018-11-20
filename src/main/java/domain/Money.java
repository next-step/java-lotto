package domain;

import java.util.List;

public class Money {
//    public static int sum(List<Rank> values) {
//        int sum = 0;
//        for(Rank rank : values) {
//            sum += rank.getWinningMoney();
//        }
//        return sum;
//    }

    public static double profitRatio(int putMoney, int totalProfitMoney) {
        double number = (double)totalProfitMoney / (double)putMoney;
        return Math.round(number*100)/100.0;
    }

    public static Integer sum(Rank rank, Integer integer) {
        return rank.getWinningMoney() * integer;
    }
}
