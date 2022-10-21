package lottoGame;

import lottoGame.model.TicketPrice;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.EnumMap;
import java.util.List;

public class RankResult {
    private final EnumMap<Rank, Integer> lotteryBoard = new EnumMap<>(Rank.class);
    private final DecimalFormat df = new DecimalFormat("0.00");

    public EnumMap<Rank, Integer> getLotteryBoard() {
        return lotteryBoard;
    }

    public EnumMap<Rank, Integer> putResult(List<Integer> matchNumbers) {
        for (Rank rank : Rank.values()) {
            lotteryBoard.put(rank, rank.findMatch(matchNumbers));
        }
        return lotteryBoard;
    }

    public BigDecimal getYield(Double amount) {

        return BigDecimal.valueOf(getTotalSum() / amount).setScale(2, RoundingMode.FLOOR);
    }

    private Integer getTotalSum() {
        return lotteryBoard.entrySet()
                .stream()
                .map(winningEntry -> winningEntry.getKey().getRank() * winningEntry.getValue())
                .reduce(Integer::sum)
                .orElse(0);
    }

}
