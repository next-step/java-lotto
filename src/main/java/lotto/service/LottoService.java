package lotto.service;

import lotto.domain.LottoNumbers;
import lotto.domain.LottoMoney;
import lotto.domain.LottoResult;
import lotto.util.WinningUtils;
import lotto.domain.WinningPrize;

import java.util.ArrayList;
import java.util.LinkedHashMap;
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

    public int getTotalWinningAmount(int bonusBall, List<LottoNumbers> userLottos, Set<Integer> winningNumbers) {
        int totalWinningAmount = 0;

        for (LottoNumbers userLotto : userLottos) {
            LottoResult lottoResult = WinningUtils.countMatchingNumbers(bonusBall, winningNumbers, userLotto);
            totalWinningAmount = addTotalWinningAmount(lottoResult, totalWinningAmount);
        }
        return totalWinningAmount;
    }

    private int addTotalWinningAmount(LottoResult lottoResult, int totalWinningAmount) {
        if (lottoResult.getMatchCount() >= MINIMUM_MATCH_COUNT) {
            totalWinningAmount = processWinningLotto(lottoResult, totalWinningAmount);
        }
        return totalWinningAmount;
    }

    private int processWinningLotto(LottoResult lottoResult, int totalWinningAmount) {
        WinningPrize prize = WinningPrize.getPrizeByMatchCount(lottoResult.getMatchCount(), lottoResult.isBonus());
        if (prize != null) {
            prize.incrementCount();
            totalWinningAmount += prize.getPrizeMoney();
        }
        return totalWinningAmount;
    }

    public Map<WinningPrize, Integer> calculateWinningResults() {
        Map<WinningPrize, Integer> results = new LinkedHashMap<>();

        for (WinningPrize prize : WinningPrize.values()) {
            results.put(prize, prize.getCount());
        }
        return results;
    }

}
