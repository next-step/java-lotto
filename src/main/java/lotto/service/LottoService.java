package lotto.service;

import lotto.domain.LottoMoney;
import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.domain.WinningPrize;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LottoService {

    public static final int MINIMUM_MATCH_COUNT = 3;

    public int calculateLottoAmount(LottoMoney money) {
        return money.calculateLottoAmount();
    }

    public List<LottoTicket> generateLottoTickets(int amount) {
        List<LottoTicket> userLottos = new ArrayList<>();
        for (int i = 1; i <= amount; i++) {
            userLottos.add(new LottoTicket(LottoTicket.generateRandomNumbers()));
        }
        return userLottos;
    }

    public LottoResult getLottoResult(LottoTicket userTicket, LottoTicket winningTicket) {
        int matchCount = userTicket.countMatchingNumbers(winningTicket);
        boolean isBonus = userTicket.isBonusMatched(winningTicket);
        return new LottoResult(matchCount, isBonus);
    }

    public int getTotalWinningAmount(List<LottoTicket> userLottos, LottoTicket winningTicket) {
        return userLottos.stream()
                .map(userTicket -> getLottoResult(userTicket, winningTicket))
                .mapToInt(lottoResult -> addTotalWinningAmount(lottoResult, 0))
                .sum();
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

    public double calculateWinningRate(int moneyAmount, int totalWinningAmount) {
        if (moneyAmount == 0) {
            return 0.0;
        }
        return (double) totalWinningAmount / moneyAmount * 100;
    }
}
