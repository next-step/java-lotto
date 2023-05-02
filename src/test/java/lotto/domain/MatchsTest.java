package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

class MatchsTest {

    @Test
    void calculateWinningAmount() {
        Matchs matchs = getMatchs();

        Money winningAmount = matchs.calculateWinningAmount();

        assertThat(winningAmount).isEqualTo(new Money(2_001_555_000L));
    }

    public static Matchs getMatchs() {
        Map<Match, Long> map = new LinkedHashMap<>();
        map.put(Match.THREE, 1L);
        map.put(Match.FOUR, 1L);
        map.put(Match.FIVE, 1L);
        map.put(Match.SIX, 1L);

        return new Matchs(map);
    }
}