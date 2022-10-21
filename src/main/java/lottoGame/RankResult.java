package lottoGame;

import java.text.DecimalFormat;
import java.util.EnumMap;
import java.util.List;
import java.util.Objects;

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

    public String getYield(Integer amount) {
        return df.format((double) getTotalSum() / amount);
    }

    private Integer getTotalSum() {
        return lotteryBoard.entrySet()
                .stream()
                .map(winningEntry -> winningEntry.getKey().getRank() * winningEntry.getValue())
                .reduce(Integer::sum)
                .orElse(0);
    }

}
