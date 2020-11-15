package step3.domain.lotto.firstcollection;

import step3.Constant;
import step3.domain.lotto.LottoTicket;
import step3.domain.lotto.WinningNumbers;
import step3.type.WinningType;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WinningResults {
    public static final long DEFAULT_COUNT_LONG = 0L;
    public static final Integer DEFAULT_COUNT_INTEGER = 0;
    public static final double DECIMAL_POINT_TWO_FIXED = 100D;

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

    public Integer countByWinningType(WinningType type) {
        return Optional.ofNullable(winningResults.get(type)).orElse(DEFAULT_COUNT_INTEGER);
    }


    public void forEach(BiConsumer<WinningType, Integer> consumer) {
        Objects.requireNonNull(consumer);
        winningResults.forEach(consumer);
    }

    public double getRevenue(int ticketSize) {
        Long totalAmount = winningResults.keySet()
                .stream()
                .map(type -> {
                    Integer matchCount = winningResults.get(type);
                    return WinningType.getWinningAmount(type) * matchCount;
                })
                .reduce(Long::sum)
                .orElseThrow(IllegalArgumentException::new);

        return calculateRateAndFixedTwo(totalAmount, ticketSize);
    }

    private double calculateRateAndFixedTwo(double totalAmount, int ticketSize) {
        return Math.round((totalAmount / getExpenses(ticketSize)) * DECIMAL_POINT_TWO_FIXED / DECIMAL_POINT_TWO_FIXED);
    }

    private double getExpenses(int ticketSize) {
        return ticketSize * Constant.LOTTO_PRICE;
    }
}
