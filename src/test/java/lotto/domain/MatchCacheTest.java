package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class MatchCacheTest {

    MatchCache matchCache;

    private static Stream<Arguments> saveStateMethodSource() {
        return Stream.of(
                Arguments.of(1, false, new int[]{1, 0, 0, 0, 0, 0}, 0),
                Arguments.of(3, false, new int[]{0, 0, 1, 0, 0, 0}, 0),
                Arguments.of(5, true, new int[]{0, 0, 0, 0, 0, 0}, 1),
                Arguments.of(5, false, new int[]{0, 0, 0, 0, 1, 0}, 0)
        );
    }

    @BeforeEach
    void setUp() {
        matchCache = new MatchCache();
    }

    @ParameterizedTest
    @DisplayName("일치 개수 저장(1 -> [1,0,0,0,0,0], 3 -> [0,0,1,0,0,0], (5,true) -> [0,0,0,0,0,0], (5, false) -> [0,0,0,0,1,0])")
    @MethodSource("saveStateMethodSource")
    void save_state(int matchCount, boolean isBonus, int[] result, int bonusResult) {
        matchCache.save(matchCount, isBonus);
        assertThat(matchCache).isEqualTo(new MatchCache(result, bonusResult));
    }

    @Test
    @DisplayName("일치 개수 누적 저장(1,1,3,3,3,5(bonus), 5(no_bonus), 5(bonus) -> [2,0,3,0,1,0],2)")
    void save_accumulate_state() {
        matchCache.save(1,false);
        matchCache.save(1,false);
        matchCache.save(3,false);
        matchCache.save(3,false);
        matchCache.save(3,false);
        matchCache.save(5, true);
        matchCache.save(5, false);
        matchCache.save(5, true);


        assertThat(matchCache).isEqualTo(new MatchCache(new int[]{2, 0, 3, 0, 1, 0}, 2));
    }
}
