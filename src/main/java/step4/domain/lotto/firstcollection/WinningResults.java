package step4.domain.lotto.firstcollection;

import step4.domain.lotto.WinningNumbers;
import step4.type.WinningType;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WinningResults {
    public static final long DEFAULT_COUNT_LONG = 0L;
    public static final double DECIMAL_POINT_TWO_FIXED = 100D;
    public static final int REVENUE_ANCHOR_POINT = 1;

    private final Map<WinningType, Integer> winningResults;

    private WinningResults(Map<WinningType, Integer> winningResults) {
        this.winningResults = winningResults;
    }

    public static WinningResults of(Map<WinningType, Integer> winningResults) {
        return new WinningResults(winningResults);
    }


    public static WinningResults of(LottoTickets tickets, WinningNumbers winningNumbers) {
        return new WinningResults(aggregate(tickets, winningNumbers));
    }

    private static Map<WinningType, Integer> aggregate(LottoTickets tickets, WinningNumbers winningNumbers) {

        return Arrays.stream(WinningType.values())
                .filter(winningType -> !Objects.equals(winningType, WinningType.RANK_ETC))
                .collect(Collectors.toMap(Function.identity(), (winningType) -> Math.toIntExact(
                        Optional.ofNullable(countByWinningType(tickets, winningNumbers)
                                .get(winningType))
                                .orElse(DEFAULT_COUNT_LONG)
                )));
    }

    private static Map<WinningType, Long> countByWinningType(LottoTickets tickets, WinningNumbers winningNumbers) {
        return tickets.countByWinningType(winningNumbers);
    }

    public void forEach(BiConsumer<WinningType, Integer> consumer) {
        Objects.requireNonNull(consumer);
        winningResults.forEach(consumer);
    }

    public Long getWinningAmount() {
        return winningResults.entrySet()
                .stream()
                .map(entry -> WinningType.getWinningAmount(entry.getKey()) * entry.getValue())
                .reduce(Long::sum)
                .orElseThrow(IllegalArgumentException::new);
    }


}
