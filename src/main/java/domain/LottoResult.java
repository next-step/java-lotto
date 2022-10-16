package domain;

import enums.LottoWinnerRank;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LottoResult {

    private static final int MIN_MATCHING_NUMBER = 3;
    private static final int MAX_MATCHING_NUMBER = 6;

    private int[] matchFoundCount = new int[7];

    public LottoResult() {
    }

    public void findMatchLottoCount(Lotto winnerNumber, Lottos lottos) {

        for (Lotto randomLotto : lottos.getLottoNumbers()) {
            List<Integer> matchNumberFounds = compareWinnerNumber(randomLotto, winnerNumber);
            matchFoundCount[matchNumberFounds.size()] += 1;
        }
    }

    private List<Integer> compareWinnerNumber(Lotto randomLotto, Lotto winnerNumber) {

        return randomLotto.getLotto()
            .stream()
            .filter(randomLottoNumber -> winnerNumber.getLotto()
                .stream()
                .anyMatch(Predicate.isEqual(randomLottoNumber)))
            .collect(Collectors.toList());
    }

    public double calculateEarningRate(Money purchasedMoney) {

        double totalEarningMoney = 0;

        for (int i = MIN_MATCHING_NUMBER; i <= MAX_MATCHING_NUMBER; i++) {
            totalEarningMoney += LottoWinnerRank.getWinningMoney(i) * matchFoundCount[i];
        }

        return Math.round(totalEarningMoney / purchasedMoney.getMoney() * 100) / 100.0;
    }

    public int[] getMatchFoundCount() {
        return matchFoundCount;
    }

}
