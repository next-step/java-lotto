package lottoGame;

import java.text.DecimalFormat;
import java.util.EnumMap;
import java.util.List;

public class RankResult {
    private final EnumMap<Ranks, Integer> lotteryBoard = new EnumMap<>(Ranks.class);
    private final DecimalFormat df = new DecimalFormat("0.00");

    public EnumMap<Ranks, Integer> getLotteryBoard() {
        return lotteryBoard;
    }

    public void putResult(List<Integer> matchNumbers) {
        for (Ranks ranks : Ranks.values()) {
            lotteryBoard.put(ranks, ranks.findMatch(matchNumbers));
        }
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
