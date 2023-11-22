package lotto.domain.summary;

import lotto.constants.Winning;

import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class WinningSummary {

    private static final String PRIZE_MESSAGE = "%,d개 일치 (%,d원)";
    private static final String MATCH_MESSAGE = " - %,d개";
    private static final String SECOND_MATCH_MESSAGE = ", 보너스 볼 일치 - %,d개";

    private final Map<Winning, Long> winnings;


    private WinningSummary() {
        winnings = prizeWinningMap();
    }

    public static WinningSummary newInstance() {
        return new WinningSummary();
    }

    private Map<Winning, Long> prizeWinningMap() {
        return Winning.prizeWinning()
                .stream()
                .collect(Collectors.toMap(
                        winning -> winning,
                        winning -> 0L
                ));
    }

    public void addWinning(Winning winning) {
        addWinning(winning, 1L);
    }

    public void addWinning(Winning winning, Long count) {
        winnings.merge(winning, count, Long::sum);
    }

    public Map<Winning, Long> winnings() {
        return winnings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningSummary that = (WinningSummary) o;
        return Objects.equals(winnings, that.winnings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winnings);
    }

    @Override
    public String toString() {
        Set<Winning> prizeWinnings = Winning.prizeWinning();

        StringBuffer stringBuffer = new StringBuffer();
        for (Winning prizeWinning : prizeWinnings) {
            Long matchCount = winnings.get(prizeWinning);
            makeMessage(prizeWinning, stringBuffer, matchCount);
        }

        return stringBuffer.toString();
    }

    private void makeMessage(Winning prizeWinning, StringBuffer stringBuffer, Long matchCount) {
        stringBuffer.append(String.format(PRIZE_MESSAGE, prizeWinning.matchCount(), prizeWinning.prize()));

        if (prizeWinning == Winning.SECOND) {
            stringBuffer.append(String.format(SECOND_MATCH_MESSAGE, matchCount)).append("\n");
            return;
        }

        stringBuffer.append(String.format(MATCH_MESSAGE, matchCount)).append("\n");
    }
}
