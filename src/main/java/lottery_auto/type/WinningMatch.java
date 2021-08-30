package lottery_auto.type;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum WinningMatch {
    MATCH_3(3,5_000),
    MATCH_4(4,50_000),
    MATCH_5(5,1_500_000),
    MATCH_6(6,2_000_000_000),
    MATCH_NON_VALUE(0,0);

    private final int count;
    private final int winnings;

    WinningMatch(int count, int winnings){
        this.count = count;
        this.winnings = winnings;
    }

    public static WinningMatch equal(int match){
        return Arrays.asList(WinningMatch.values())
                .stream()
                .filter(w-> w.count == match)
                .findAny()
                .orElse(MATCH_NON_VALUE);
    }

    public static List<WinningMatch> getWinningMatchesExistsNonMatchValue(){
        return Arrays.asList(WinningMatch.values())
                .stream()
                .filter(winningMatch -> winningMatch != WinningMatch.MATCH_NON_VALUE)
                .collect(Collectors.toList());
    }


    public int getWinnings() {
        return winnings;
    }

    public int getCount() { return count; }

    @Override
    public String toString() {
        return String.valueOf(count);
    }
}
