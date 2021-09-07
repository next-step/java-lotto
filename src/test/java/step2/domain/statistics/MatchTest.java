package step2.domain.statistics;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class MatchTest {
    @Test
    @DisplayName("디폴트 생성자 생성")
    void createWithDefaultConstructorTest() {
        final Match actual = new Match();
        final Map<Rank, Integer> matchMap = new HashMap(){
            {
                put(Rank.FIFTH, 0);
                put(Rank.FOURTH, 0);
                put(Rank.THIRD, 0);
                put(Rank.SECOND, 0);
                put(Rank.FIRST, 0);
            }
        };
        final Match expected = new Match(matchMap);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void createConstructorTest() {
        final Match actual = new Match(Rank.FIFTH);
        final Map<Rank, Integer> matchMap = new HashMap(){
            {
                put(Rank.FIFTH, 1);
                put(Rank.FOURTH, 0);
                put(Rank.THIRD, 0);
                put(Rank.SECOND, 0);
                put(Rank.FIRST, 0);
            }
        };
        final Match expected = new Match(matchMap);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void addTest() {
        final Match actual = new Match();
        actual.add(Rank.FIFTH);
        actual.add(Rank.FIFTH);
        actual.add(Rank.NONE);

        final Match expected = new Match(Rank.FIFTH, 2);
        assertThat(actual).isEqualTo(expected);
    }
}