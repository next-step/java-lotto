package step3;

import java.util.Map;

public class Money {

    private static final int LOTTO_PRICE = 1000;
    private static long totalPrize = 0;
    private int inputCash;

    public Money(int inputCash) {
        validateMoney(inputCash);
        this.inputCash = inputCash / LOTTO_PRICE;
    }

    public int getLottoCount() {
        return this.inputCash;
    }

    public long getTotalPrize() {
        return totalPrize;
    }

    public int getInputCash() {
        return this.inputCash * LOTTO_PRICE;
    }

    public static void validateMoney(int inputCash) {
        if (inputCash < LOTTO_PRICE)
            throw new IllegalArgumentException("로또는 1장에 " + LOTTO_PRICE + " 원 입니다.");
    }

    public double winningPrize(Map<Integer, Integer> summaryResult) {
        int spandMoney = getInputCash();
        for (int key : summaryResult.keySet()) {
            totalPrize += calculateTotalPrize(summaryResult, key);
        }

        if (totalPrize > 0) {
            double earningRate = Math.abs(totalPrize - spandMoney);
            return earningRate / spandMoney;
        }
        return 0;
    }

    private long calculateTotalPrize(Map<Integer, Integer> summaryResult, int key) {
        if (LottoGenerator.BONUS_WINNING_VALID_NUMBER == key && LottoLottery.bonusCheck) {
            return sumBonusPrize(summaryResult, key);
        }
        return Prize.matchOfCount(key, false).getWinningMoney() * summaryResult.get(key);
    }

    private long sumBonusPrize(Map<Integer, Integer> summaryResult, int key) {
        long bonusPrize = Prize.matchOfCount(key, true).getWinningMoney() * LottoLottery.BONUS_WINNING_COUNT;
        int thirdPrizeCount = summaryResult.get(key) - LottoLottery.BONUS_WINNING_COUNT;

        return bonusPrize + (Prize.matchOfCount(key, false).getWinningMoney() * thirdPrizeCount);
    }
}
