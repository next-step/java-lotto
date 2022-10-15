package domain;

import enums.WinnerInfo;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Statistic {

    private static final int MIN_MATCHING_NUMBER = 3;
    private static final int MAX_MATCHING_NUMBER = 6;

    private int[] matchFoundCount = new int[7];

    public Statistic() {
    }

    public static String lossMessageFormat(double rate) {
        return rate < 1 ? "(기준이 1이기 때문에 결과적으로 손해라는 의미임)" : "";
    }

    public void findMatchLottoCount(Lotto winnerNumber, LottoNumbers lottoNumbers) {

        for (Lotto randomLotto : lottoNumbers.getLottoNumbers()) {
            List<Integer> matchNumberFounds = compareWinnerNumber(randomLotto, winnerNumber);
            matchFoundCount[matchNumberFounds.size()] += 1;
        }
    }

    private List<Integer> compareWinnerNumber(Lotto randomLotto, Lotto winnerNumber) {

        return Arrays.stream(randomLotto.getLotto())
            .filter(randomLottoNumber -> Arrays.stream(winnerNumber
                    .getLotto())
                .anyMatch(Predicate.isEqual(randomLottoNumber)))
            .collect(Collectors.toList());
    }

    public double calculateEarningRate(Money purchasedMoney) {

        double totalEarningMoney = 0;

        for (int i = MIN_MATCHING_NUMBER; i <= MAX_MATCHING_NUMBER; i++) {
            totalEarningMoney += WinnerInfo.getWinningMoney(i) * matchFoundCount[i];
        }

        return Math.round(totalEarningMoney / purchasedMoney.getMoney() * 100) / 100.0;
    }

    public int[] getMatchFoundCount() {
        return matchFoundCount;
    }

}
