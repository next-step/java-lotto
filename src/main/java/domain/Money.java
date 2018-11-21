package domain;

public class Money {
    static final int PRICE = 1_000;

    public static double profitRatio(int putMoney, int totalProfitMoney) {
        double number = (double)totalProfitMoney / (double)putMoney;
        return Math.round(number*100)/100.0;
    }

    public static Integer sum(Rank rank, Integer integer) {
        return rank.getWinningMoney() * integer;
    }

    public static int turnOfLotto(int i) {
        return i/PRICE;
    }
}
