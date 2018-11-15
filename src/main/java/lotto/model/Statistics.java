package lotto.model;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

/**
 * 통계
 */
public class Statistics {
    private Map<PrizeType, Long> results;

    public Statistics(List<Ticket> tickets, WinningTicket winningTicket) {
        /*
        일치 갯수별로 그룹핑한 맵
        @Key : 당첨타입
        @Value : 당첨 타입별 티켓 수
        */
        results = tickets.stream()
                .collect(groupingBy(i ->
                        PrizeType.valueOf(i.countMatch(winningTicket.getNums()), i.hasBonusNum(winningTicket.getBonusNum())), Collectors.counting()));
    }

    /**
     * 일치 갯수그룹 갯수 가져오기
     *
     * @param num
     * @return
     */
    public int getMatchGroupNum(PrizeType num) {
        return Optional.ofNullable(results.get(num))
                .orElse(Long.valueOf(0))
                .intValue();
    }

    /**
     * 수익 가져오기
     *
     * @return
     */
    public int getProfit() {
        return Arrays.stream(PrizeType.values())
                .mapToInt(p -> p.getPrizeMoney(getMatchGroupNum(p)))
                .sum();
    }

}
