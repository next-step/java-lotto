package ui;

import lotto.Rank;

import java.util.Objects;

public class RankSentenceProvider {
    public static String sentence(Rank rank, int count) {
        if (Objects.requireNonNull(rank) == Rank.SECOND) {
            return String.format("%d개 일치 보너스 볼 일치(%s)- %d개", rank.getMatchNumberCount(), rank.getWinPrice(), count);
        }
        return String.format("%d개 일치 (%s)- %d개", rank.getMatchNumberCount(), rank.getWinPrice(), count);
    }
}
