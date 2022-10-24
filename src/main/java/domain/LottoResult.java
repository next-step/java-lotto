package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import enums.LottoWinnerRank;

public class LottoResult {

    private static final int MIN_MATCHING_NUMBER = 3;
    private static final int MAX_MATCHING_NUMBER = 6;

    private final Map<Integer, Integer> matchFoundCount = new HashMap<>();

    public LottoResult() {
    }

    public void findMatchLottoCount(Lotto winnerNumber, Lottos lottos) {

        for (Lotto randomLotto : lottos.getLottoNumbers()) {
            List<Integer> matchNumberFounds = compareWinnerNumber(randomLotto, winnerNumber);

            if (matchFoundCount.containsKey(matchNumberFounds.size())) {
                matchFoundCount.put(matchNumberFounds.size(), matchFoundCount.get(matchNumberFounds.size()) + 1);
            }
            if (!matchFoundCount.containsKey(matchNumberFounds.size())) {
                matchFoundCount.put(matchNumberFounds.size(), 1);
            }
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

    private List<Integer> checkBonusNumber(Lotto randomLotto, Integer bonusNumber) {

        return ran
    }

    public double calculateEarningRate(Money purchasedMoney) {

        double totalEarningMoney = 0;

        for (int i = MIN_MATCHING_NUMBER; i <= MAX_MATCHING_NUMBER; i++) {
            totalEarningMoney += LottoWinnerRank.getWinningMoney(i) * matchFoundCount.getOrDefault(i, 0);
        }

        return Math.round(totalEarningMoney / purchasedMoney.getMoney() * 100) / 100.0;
    }

    public Map<Integer, Integer> getMatchFoundCount() {
        return matchFoundCount;
    }

}
