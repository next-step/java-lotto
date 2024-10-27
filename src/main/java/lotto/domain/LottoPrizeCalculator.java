package lotto.domain;

public class LottoPrizeCalculator {

    private static final Integer LOTTO_PRICE = 1000;
    private static final int[] prizeMoney = {0, 0, 0, 5000, 50000, 1500000, 2000000000};

    public static Double calculateRateOfReturn(LottoChecker lottoChecker) {
        int prize = 0;
        for (int i = 3; i < 7; i++) {
            prize += calculatePrizeByNumberAndCount(i, lottoChecker.getWinnerCount(i));
        }
        return (double) prize / (lottoChecker.getPurchaseCount() * LOTTO_PRICE);
    }

    public static Integer calculatePrizeByNumberAndCount(int numberOfMatch, int count) {
        return count * prizeMoney[numberOfMatch];
    }

    public static Integer getPrizeByIndex(int index) {
        return prizeMoney[index];
    }
}
