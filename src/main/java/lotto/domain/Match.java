package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Match {
    public static final int THREE_MATCH = 3;
    public static final int SIX_MATCH = 6;

    private final List<Lotto> lottos;
    private final WinningNumber winningNumber;

    public Match(final List<Lotto> lottos, final String winningNumber) {
        this.lottos = lottos;
        this.winningNumber = new WinningNumber(winningNumber);
    }

    public Winnings winnings() {
        List<Winning> winnings = new ArrayList<>();
        for (int matchCount = THREE_MATCH; matchCount <= SIX_MATCH; matchCount++) {
            Matches matches = winningNumber.countMatches(lottos);
            Winning winning = matches.winning(matchCount);
            winnings.add(winning);
        }
        return new Winnings(winnings);
    }
}
