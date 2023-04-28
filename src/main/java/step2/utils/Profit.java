package step2.utils;

public class Profit {

    private Profit() {
    }

    public static String getRateOfReturn(int money, int winningMoney) {

        return String.format("%.2f", (double) winningMoney / (double) money);
    }
}
