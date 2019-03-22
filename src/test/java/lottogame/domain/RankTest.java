package lottogame.domain;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lottogame.domain.Rank.*;
import static org.junit.Assert.*;

public class RankTest {

    @Test
    public void valueOf_MISS() {
        List<Integer> invalidMatchedCounts = getRangedNumbers(-1, 2);
        invalidMatchedCounts.add(7);

        for (int curMatchedCount : invalidMatchedCounts) {
            assertEquals(MISS, Rank.valueOf(getMatchStatus(curMatchedCount, false)));
            assertEquals(MISS, Rank.valueOf(getMatchStatus(curMatchedCount, true)));
        }
    }

    @Test
    public void valueOf_FIFTH() {
        assertEquals(FIFTH, Rank.valueOf(getMatchStatus(3, false)));
        assertEquals(FIFTH, Rank.valueOf(getMatchStatus(3, true)));
    }

    @Test
    public void valueOf_FOURTH() {
        assertEquals(FOURTH, Rank.valueOf(getMatchStatus(4, false)));
        assertEquals(FOURTH, Rank.valueOf(getMatchStatus(4, true)));
    }

    @Test
    public void valueOf_THIRD() {
        assertEquals(THIRD, Rank.valueOf(getMatchStatus(5, false)));
    }

    @Test
    public void valueOf_SECOND() {
        assertEquals(SECOND, Rank.valueOf(getMatchStatus(5, true)));
    }

    @Test
    public void valueOf_FIRST() {
        assertEquals(FIRST, Rank.valueOf(getMatchStatus(6, false)));
    }

    private MatchStatus getMatchStatus(int matchedCount, boolean bonusNumberMatched) {
        return new MatchStatus(matchedCount, bonusNumberMatched);
    }

    private List<Integer> getRangedNumbers(int from, int to) {
        return IntStream.rangeClosed(from, to)
                .boxed()
                .collect(Collectors.toList());
    }
}