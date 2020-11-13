package step3.domain.lotto;

import step3.type.WinningType;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WinningNumbers {
    private static final int INIT_WINNING_COUNT = 0;
    private static final int NOT_EXISTS_INDEX = -1;
    private static final String DELIMITER = ",";
    private final MarkingNumbers winningNumbers;
    private final LottoNumber bonusBall;

    private WinningNumbers(MarkingNumbers winningNumbers, LottoNumber bonusBall) {
        this.winningNumbers = winningNumbers;
        this.bonusBall = bonusBall;
    }

    public static WinningNumbers of(String string, int bonusBall) {
        isValid(string);
        MarkingNumbers splits = stringToObj(string);
        return new WinningNumbers(splits, LottoNumber.ofBonus(bonusBall, splits));
    }

    public static WinningNumbers of(Set<LottoNumber> list, int bonusBall) {
        isValid(list);
        MarkingNumbers markingNumbers = new MarkingNumbers(list);
        return new WinningNumbers(markingNumbers, LottoNumber.ofBonus(bonusBall, markingNumbers));
    }

    private static MarkingNumbers stringToObj(String string) {
        Set<LottoNumber> collect = Stream.of(string.split(DELIMITER))
                .map(value -> {
                    String trim = value.trim();
                    return new LottoNumber(Integer.parseInt(trim));
                })
                .collect(Collectors.toSet());
        return new MarkingNumbers(collect);
    }

    public WinningType getWinningStatistics(LottoTicket ticket) {
        return compareWinningNumber(ticket);
    }

    public Map<WinningType, Integer> getWinningStatistics(LottoTickets tickets) {
        Map<WinningType, Integer> winningStatistics = getInitWinningStatisticsMap();
        tickets.getTickets()
                .forEach(ticket -> {
                    WinningType winningType = compareWinningNumber(ticket);
                    appendWinningCount(winningStatistics, winningType);
                });
        return winningStatistics;
    }

    public WinningType compareWinningNumber(LottoTicket ticket) {
        int matchCount = winningNumbers.countEquals(ticket);
        return WinningType.getType(matchCount, ticket.isMarked(bonusBall));
    }

    private Map<WinningType, Integer> getInitWinningStatisticsMap() {
        return new HashMap<WinningType, Integer>() {{
            put(WinningType.RANK_ONE, INIT_WINNING_COUNT);
            put(WinningType.RANK_TWO, INIT_WINNING_COUNT);
            put(WinningType.RANK_TWO_BONUS, INIT_WINNING_COUNT);
            put(WinningType.RANK_THREE, INIT_WINNING_COUNT);
            put(WinningType.RANK_FOUR, INIT_WINNING_COUNT);
        }};
    }

    private void appendWinningCount(Map<WinningType, Integer> map, WinningType type) {
        if (!WinningType.RANK_ETC.equals(type)) {
            Integer findInteger = map.getOrDefault(type, NOT_EXISTS_INDEX);
            map.put(type, increaseWinningCount(findInteger));
        }
    }

    private int increaseWinningCount(Integer count) {
        if (count <= 0) {
            count = INIT_WINNING_COUNT;
        }
        return ++count;
    }

    private static void isValid(String string) {
        if (Objects.isNull(string) || string.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private static void isValid(Set<LottoNumber> list) {
        if (list.isEmpty() || list.size() < 6) {
            throw new IllegalArgumentException();
        }
    }
}
