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
                Arguments.of(1, new int[]{1, 0, 0, 0, 0, 0}),
                Arguments.of(3, new int[]{0, 0, 1, 0, 0, 0}),
                Arguments.of(5, new int[]{0, 0, 0, 0, 1, 0})
        );
    }

    @BeforeEach
    void setUp() {
        matchCache = new MatchCache();
    }

    @ParameterizedTest
    @DisplayName("일치 개수 저장(1 -> [1,0,0,0,0,0], 3 -> 1 -> [0,0,1,0,0,0], 5 -> 1 -> [0,0,0,0,1,0])")
    @MethodSource("saveStateMethodSource")
    void save_state(int matchCount, int[] result) {
        matchCache.save(matchCount);
        assertThat(matchCache).isEqualTo(new MatchCache(result));
    }

    @Test
    @DisplayName("일치 개수 누적 저장(1,1,3,3,3,5 -> [2,0,3,0,1,0])")
    void save_accumulate_state() {
        matchCache.save(1);
        matchCache.save(1);
        matchCache.save(3);
        matchCache.save(3);
        matchCache.save(3);
        matchCache.save(5);
        assertThat(matchCache).isEqualTo(new MatchCache(new int[]{2, 0, 3, 0, 1, 0}));
    }

    @Test
    void to_string() {
        matchCache = new MatchCache(new int[]{1, 2, 0, 1, 3, 4});
        System.out.println("3개 일치 (5000원)- 0개\n4개 일치 (50000원)- 1개\n5개 일치 (1500000원)- 3개\n6개 일치 (2000000000원) - 4개\n");
    }
}
