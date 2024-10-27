package lotto.service;

import lotto.domain.LottoNumbers;
import lotto.domain.LottoMoney;
import lotto.util.WinningUtils;
import lotto.domain.WinningPrize;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LottoService {

    public static final int MINIMUM_MATCH_COUNT = 3;

    public int calculateLottoAmount(LottoMoney money) {
        return money.calculateLottoAmount();
    }

    public List<LottoNumbers> generateLottoNumbers(int amount) {
        List<LottoNumbers> userLottos = new ArrayList<>();
        for (int i = 1; i <= amount; i++) {
            LottoNumbers selectedNumbers = LottoNumbers.generateLotto();
            userLottos.add(selectedNumbers);
        }
        return userLottos;
    }

    public Map<Integer, Integer> initializeMatchCountMap() {
        Map<Integer, Integer> matchCountMap = new HashMap<>();
        for (WinningPrize prize : WinningPrize.values()) {
            matchCountMap.put(prize.getMatchCount(), 0);
        }
        return matchCountMap;
    }

    public int getTotalWinningAmount(List<LottoNumbers> userLottos, Set<Integer> winningNumbers, Map<Integer, Integer> matchCountMap) {
        int totalWinningAmount = 0;
        for (LottoNumbers userLotto : userLottos) {
            int matchCount = WinningUtils.countMatchingNumbers(winningNumbers, userLotto);
            totalWinningAmount = calculateWinningAmount(matchCountMap, matchCount, totalWinningAmount);
        }
        return totalWinningAmount;
    }

    private static int calculateWinningAmount(Map<Integer, Integer> matchCountMap, int matchCount, int totalWinningAmount) {
        if (matchCount >= MINIMUM_MATCH_COUNT) {
            matchCountMap.put(matchCount, matchCountMap.get(matchCount) + 1);
            totalWinningAmount += WinningUtils.getPrizeMoney(matchCount);
        }
        return totalWinningAmount;
    }
}
