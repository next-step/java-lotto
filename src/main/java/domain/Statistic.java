package domain;

import enums.WinnerInfo;
import java.util.Arrays;

public class Statistic {

    private static final int MIN_MATCHING_NUMBER = 3;
    private static final int MAX_MATCHING_NUMBER = 6;

    private int[] matchFound = new int[7];
    private double rate;

    public Statistic(double rate) {
        this.rate = rate;
    }

    public void findMatchNumber(Lotto winnerNumber, LottoNumbers lottoNumbers) {
        for (Lotto randomLotto : lottoNumbers.getLottoNumbers()) {
            int matchNumberFound = 0;

            for (int i = 0; i < 6; i++) {
                boolean contain = Arrays.asList(randomLotto.getLotto())
                    .contains(winnerNumber.getLotto()[i]);
                if (contain) {
                    matchNumberFound += 1;
                }
            }
            matchFound[matchNumberFound] += 1;
        }
    }

    public double calculateEarningRate(Money purchasedMoney) {

        int totalEarningMoney = 0;

        for (int i = MIN_MATCHING_NUMBER; i < MAX_MATCHING_NUMBER; i++) {
            totalEarningMoney += WinnerInfo.getWinningMoney(matchFound[i]) * i;
        }
        this.rate =  Math.round(totalEarningMoney / purchasedMoney.getMoney() * 100.0) / 100.00;
        return rate;
    }

    public static String lossMessageFormat(double rate) {
        return rate < 1 ? "(기준이 1이기 때문에 결과적으로 손해라는 의미임)" : "";
    }


    public int[] getMatchFound() {
        return matchFound;
    }

    public double getRate() {
        return rate;
    }
}
