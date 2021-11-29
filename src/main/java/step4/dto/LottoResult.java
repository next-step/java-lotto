package step4.dto;

import step4.domain.Money;
import step4.domain.WinningRank;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;

import static java.util.stream.Collectors.*;

public class LottoResult {

    private final List<WinningRank> history;
    private final Double yield;
    private final WinningStatistics stat;

    private LottoResult(List<WinningRank> history, Double yield, WinningStatistics stat) {
        this.history = history;
        this.yield = yield;
        this.stat = stat;
    }

    public static LottoResult of(Money originMoney, List<WinningRank> history, Money winningMoney) {
        BigDecimal yieldOfDecimal = winningMoney.divide(originMoney);
        WinningStatistics stat = history.stream()
                .filter(winningRank -> !winningRank.equals(WinningRank.NO_RANK))
                .collect(collectingAndThen(
                        groupingBy(winningRank -> winningRank, () -> new EnumMap<WinningRank, Long>(WinningRank.class), counting()),
                        WinningStatistics::new));
        return new LottoResult(new ArrayList<>(history), yieldOfDecimal.doubleValue(), stat);
    }

    public List<WinningRank> getHistory() {
        return Collections.unmodifiableList(history);
    }

    public WinningStatistics getStat() {
        return stat;

    }

    public Double getYield() {
        return yield;
    }
}
