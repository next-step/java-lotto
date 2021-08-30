package lottery_auto.domain;

import java.math.BigDecimal;
import java.util.*;

import lottery_auto.type.WinningMatch;
import java.util.stream.Collectors;

public final class WinningResult {

    private static final int MIN_NUMBER = 0;

    private final EnumMap<WinningMatch, Integer> matchMap = new EnumMap<>(WinningMatch.class);

    public WinningResult(final List<Integer> result) {
        match(result);
    }

    public int compareMatch(WinningMatch winningMatch){
        return matchMap.get(winningMatch);
    }

    public List<Integer> getWinningCount(){
        List<WinningMatch> winningMatches = WinningMatch.getWinningMatchesExistsNonMatchValue();
        return winningMatches.stream()
                .map(winningMatch -> compareMatch(winningMatch))
                .collect(Collectors.toList());
    }

    public BigDecimal sumMatchResult() {
        return matchMap.entrySet().stream()
                .map(winningMatch -> sum(winningMatch.getKey(), winningMatch.getValue()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public Double calculateProfit(BigDecimal amount){
        return sumMatchResult().divide(amount, 2, BigDecimal.ROUND_FLOOR).doubleValue();
    }


    private void match(final List<Integer> match){
        init();
        match.stream()
                .map(WinningMatch::equal)
                .forEach(winningMatch -> matchMap.put(winningMatch, matchMap.get(winningMatch) + 1));
    }

    private void init(){
        Arrays.stream(WinningMatch.values())
                .forEach(winningMatch -> matchMap.put(winningMatch, 0));
    }

    private boolean validate(WinningMatch match){
        return match.getCount() > MIN_NUMBER && !match.equals(WinningMatch.MATCH_NON_VALUE);
    }

    private BigDecimal sum(WinningMatch match, int count){
        if(validate(match)){
            return new BigDecimal(match.getWinnings() * count);
        }
        return BigDecimal.ZERO;
    }
}
