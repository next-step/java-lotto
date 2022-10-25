package lottoGame;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;

public class RankResult {
    private final EnumMap<Rank, Integer> lotteryBoard = new EnumMap<>(Rank.class);

    public EnumMap<Rank, Integer> getLotteryBoard() {
        return lotteryBoard;
    }

    public EnumMap<Rank, Integer> putResult(List<Rank> ranks) {
        for (Rank rank : Rank.values()) {
            lotteryBoard.put(rank, Collections.frequency(ranks, rank));
        }
        return lotteryBoard;
    }

    public BigDecimal getYield() {

        return BigDecimal.valueOf(getTotalSum() / (countLotto() * LottoGame.TICKET_PRICE)).setScale(2, RoundingMode.FLOOR);
    }

    private Integer getTotalSum() {
        return lotteryBoard.entrySet()
                .stream()
                .map(winningEntry -> winningEntry.getKey().getRank() * winningEntry.getValue())
                .reduce(Integer::sum)
                .orElse(0);
    }

    private Integer countLotto() {
        return lotteryBoard.values()
                .stream()
                .reduce(Integer::sum)
                .orElseThrow();
    }

}
