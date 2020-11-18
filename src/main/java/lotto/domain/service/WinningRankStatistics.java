package lotto.domain.service;

import lotto.domain.repository.WinningRank;
import lotto.domain.repository.WinningRanks;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

import static lotto.domain.util.MoneyLottoMapper.LOTTO_PRICE;

public class WinningRankStatistics {
    public static final int SCALE = 2;
    public static final RoundingMode ROUNDING_MODE = RoundingMode.HALF_UP;
    private Map<WinningRank, Integer> counter = new LinkedHashMap<>();

    public WinningRankStatistics(WinningRanks winningRanks) {
        setDefaultCounter();
        count(winningRanks);
    }

    private void count(WinningRanks winningRanks) {
        winningRanks.getWinningRanks()
                .forEach(this::add);
    }

    private void add(WinningRank winningRank) {
        counter.compute(winningRank, (key, count) -> count + 1);
    }

    private void setDefaultCounter() {
        Arrays.stream(WinningRank.values()).forEach(winningRank -> counter.put(winningRank, 0));
    }

    public Map<WinningRank, Integer> getCounter() {
        return counter;
    }

    public BigDecimal calculateYield() {
        BigDecimal totalMoney = new BigDecimal(getMoneyPayed());
        BigDecimal moneyEarned = new BigDecimal(getMoneyEarned());
        return moneyEarned.divide(totalMoney, SCALE, ROUNDING_MODE);
    }

    private int getMoneyEarned() {
        return counter.entrySet().stream()
                .mapToInt(winningRankCountEntry -> winningRankCountEntry.getKey().getTotalPrice(winningRankCountEntry.getValue()))
                .sum();
    }

    private int getMoneyPayed() {
        return counter.values().stream().mapToInt(i -> i).sum() * LOTTO_PRICE;
    }
}
