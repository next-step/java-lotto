package domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import enums.LottoWinnerRank;

public class LottoResult {

    private static final int MATCH_FIVE_NUMBER = 5;

    private final Map<LottoWinnerRank, Integer> matchFoundCount = new EnumMap<>(LottoWinnerRank.class);

    public LottoResult() {
    }

    public void findMatchLottoCount(Lotto winningLotto, Lottos lottos, BonusNumber bonusNumber) {

        for (Lotto randomLotto : lottos.getLottoNumbers()) {
            List<Integer> matchNumberFounds = compareWinnerNumber(randomLotto, winningLotto);

            LottoWinnerRank ranking = LottoWinnerRank.findKey(matchNumberFounds.size());

            if (matchNumberFounds.size() == MATCH_FIVE_NUMBER) {
                ranking = checkBonusNumber(randomLotto, bonusNumber);
            }
            updateMatchFoundCount(ranking, matchFoundCount);
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

    private LottoWinnerRank checkBonusNumber(Lotto randomLotto, BonusNumber bonusNumber) {
        if (randomLotto.getLotto().contains(bonusNumber.getBonusNumber())) {
            return LottoWinnerRank.SECOND;
        }
        return LottoWinnerRank.THIRD;
    }

    private void updateMatchFoundCount(LottoWinnerRank ranking, Map<LottoWinnerRank, Integer> matchFoundCount) {

        if (matchFoundCount.containsKey(ranking)) {
            matchFoundCount.put(ranking, matchFoundCount.get(ranking) + 1);
        }
        if (!matchFoundCount.containsKey(ranking)) {
            matchFoundCount.put(ranking, 1);
        }
    }

    public double calculateEarningRate(Money purchasedMoney) {

        double totalEarningMoney = 0;

        for (Map.Entry<LottoWinnerRank, Integer> entry : matchFoundCount.entrySet()) {
            LottoWinnerRank rank = entry.getKey();
            int rankMatchFound = entry.getValue();
            totalEarningMoney += LottoWinnerRank.getWinningMoney(rank) * rankMatchFound;
        }

        return Math.round(totalEarningMoney / purchasedMoney.getMoney() * 100) / 100.0;
    }

    public Map<LottoWinnerRank, Integer> getMatchFoundCount() {
        return matchFoundCount;
    }

}
