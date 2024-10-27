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
    private static int[] matchCount = new int[WinningPrize.values().length];

    public static int[] getMatchCount() {
        return matchCount;
    }

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

    private Map<Integer, Integer> initializeMatchCountMap() {
        Map<Integer, Integer> matchCountMap = new HashMap<>();
        for (WinningPrize prize : WinningPrize.values()) {
            matchCountMap.put(prize.getMatchCount(), 0);
        }
        return matchCountMap;
    }

    public int getTotalWinningAmount(List<LottoNumbers> userLottos, Set<Integer> winningNumbers) {
        int totalWinningAmount = 0;

        for (LottoNumbers userLotto : userLottos) {
            int count = WinningUtils.countMatchingNumbers(winningNumbers, userLotto);
            totalWinningAmount = addTotalWinningAmount(count, totalWinningAmount);
        }
        return totalWinningAmount;
    }

    private int addTotalWinningAmount(int count, int totalWinningAmount) {
        if (count >= MINIMUM_MATCH_COUNT) {
            totalWinningAmount = processWinningLotto(count, matchCount, totalWinningAmount);
        }
        return totalWinningAmount;
    }

    private int processWinningLotto(int count, int[] matchCount, int totalWinningAmount) {
        WinningPrize prize = WinningPrize.getPrizeByMatchCount(count);
        if (prize != null) {
            matchCount[prize.ordinal()]++;
            totalWinningAmount += prize.getPrizeMoney();
        }
        return totalWinningAmount;
    }

}
