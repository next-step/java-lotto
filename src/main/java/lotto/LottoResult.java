package lotto;

import java.util.Arrays;

public class LottoResult {

    private final int firstPlaceCount;
    private final int secondPlaceCount;
    private final int thirdPlaceCount;
    private final int fourthPlaceCount;
    private final int etcCount;
    private final double rateOfProfit;

    public LottoResult(int[] placeCount) {
        validate(placeCount);
        firstPlaceCount = placeCount[WinningCriteria.FIRST.idx];
        secondPlaceCount = placeCount[WinningCriteria.SECOND.idx];
        thirdPlaceCount = placeCount[WinningCriteria.THIRD.idx];
        fourthPlaceCount = placeCount[WinningCriteria.FOURTH.idx];
        etcCount = placeCount[WinningCriteria.ETC.idx];
        rateOfProfit = calculateRateOfProfit();
    }

    private void validate(int[] placeCount) {
        if (placeCount.length < 5) {
            throw new IllegalArgumentException("우승 정보 배열은 5자리 이상이어야합니다.");
        }
    }

    private double calculateRateOfProfit() {
        return ((int)((firstPlaceCount * WinningCriteria.FIRST.prize
                + secondPlaceCount * WinningCriteria.SECOND.prize
                + thirdPlaceCount * WinningCriteria.THIRD.prize
                + fourthPlaceCount * WinningCriteria.FOURTH.prize)
                / ((firstPlaceCount + secondPlaceCount + thirdPlaceCount + fourthPlaceCount + etcCount) * (double)LottoShop.LOTTO_PRICE) * 100)) / 100d;
    }

    public enum WinningCriteria {

        FIRST(6, 2000000000, 0),
        SECOND(5, 1500000, 1),
        THIRD(4, 50000, 2),
        FOURTH(3, 5000, 3),
        ETC(-1, 0, 4);

        private int matchCount;
        private int prize;
        private int idx;

        WinningCriteria(int matchCount, int prize, int idx) {
            this.matchCount = matchCount;
            this.prize = prize;
            this.idx = idx;
        }

        public static WinningCriteria of(int matchCount) {
            return Arrays.stream(WinningCriteria.values())
                    .filter(winningCriteria -> winningCriteria.matchCount == matchCount)
                    .findFirst()
                    .orElse(WinningCriteria.ETC);
        }

        public int idx() {
            return idx;
        }

    }

    public int getFirstPlaceCount() {
        return firstPlaceCount;
    }

    public int getSecondPlaceCount() {
        return secondPlaceCount;
    }

    public int getThirdPlaceCount() {
        return thirdPlaceCount;
    }

    public int getFourthPlaceCount() {
        return fourthPlaceCount;
    }

    public double getRateOfProfit() {
        return rateOfProfit;
    }

}
