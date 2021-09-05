package step2.domain;

import org.junit.jupiter.api.Test;
import step2.vo.Rank;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class MatchTest {

    @Test
    void addTest() {
        final Match match = new Match();
        match.add(3);

        final Match expected = createTestMatch(3, 1);
        assertThat(match).isEqualTo(expected);
    }


    // todo 중복 많이 나오면 class로
    private Match createTestMatch(int matchCount, int amount) {
        return new Match(createTestMatchValue(matchCount, amount),
                createTestProfitValue(matchCount, amount));
    }

    // todo 중복 많이 나오면 class로
    private Map<Rank, Integer> createTestMatchValue(int matchCount, int amount) {
        Map<Rank, Integer> match = new HashMap<>();
        match.put(Rank.FIFTH, 0);
        match.put(Rank.FOURTH, 0);
        match.put(Rank.THIRD, 0);
        match.put(Rank.FIRST, 0);
        final Rank target = Rank.createRank(matchCount);
        match.put(target, amount);
        return match;
    }

    // todo 중복 많이 나오면 class로
    private long createTestProfitValue(int matchCount, int amount) {
        final Rank rank = Rank.createRank(matchCount);
        return rank.winnings * amount;
    }
}