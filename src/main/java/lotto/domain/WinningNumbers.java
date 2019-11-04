package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by yusik on 2019/11/05.
 */
public class WinningNumbers {

    private static final int WINNING_NUMBER_SIZE = 6;
    private final List<Integer> winningNumbers;

    public WinningNumbers(List<Integer> winningNumbers) {
        validateSize(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    private void validateSize(List<Integer> winningNumbers) {
        if (winningNumbers.size() != WINNING_NUMBER_SIZE) {
            throw new RuntimeException("당첨 번호는 6개 입니다.");
        }
    }

    public Map<WinningRanking, Integer> getWinningTickets(List<LotteryTicket> tickets) {
        Map<WinningRanking, Integer> map = new HashMap<>();
        for (LotteryTicket ticket : tickets) {
            mergeIfNotNull(map, ticket);
        }
        return map;
    }

    private void mergeIfNotNull(Map<WinningRanking, Integer> map, LotteryTicket ticket) {
        WinningRanking winningRanking = ticket.getRankByMatchNumbers(winningNumbers);
        if (Objects.nonNull(winningRanking)) {
            map.merge(winningRanking, 1, Integer::sum);
        }
    }
}
