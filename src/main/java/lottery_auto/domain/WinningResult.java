package lottery_auto.domain;

import java.math.BigDecimal;
import java.util.*;

import lottery_auto.type.WinningMatch;

import java.util.stream.Collectors;

public final class WinningResult {

    private static final int MIN_NUMBER = 0;

    private final EnumMap<WinningMatch, Integer> matchList = new EnumMap<>(WinningMatch.class);

    public WinningResult(final List<Integer> result) {
        match(result);
    }

    public int compareMatch(WinningMatch winningMatch){
        return matchList.getOrDefault(winningMatch, 0);
    }

    public BigDecimal sumMatchResult() {
        return matchList.entrySet().stream()
                .map(winningMatch -> sum(winningMatch.getKey(), winningMatch.getValue()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public Double calculateProfit(BigDecimal amount){
        return sumMatchResult().divide(amount, 2, BigDecimal.ROUND_FLOOR).doubleValue();
    }

    @Override
    public String toString() {
        return matchList.entrySet().stream()
                .map(Objects::toString)
                .collect(Collectors.toList())
                .toString();
    }

    private void match(final List<Integer> match){
        init();
        match.stream()
                .map(WinningMatch::equal)
                .forEach(winningMatch -> matchList.put(winningMatch, matchList.get(winningMatch) + 1));
    }

    private void init(){
        Arrays.stream(WinningMatch.values())
                .forEach(winningMatch -> matchList.put(winningMatch, 0));
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
