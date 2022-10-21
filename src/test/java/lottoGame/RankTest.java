package lottoGame;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RankTest {

    @ParameterizedTest
    @EnumSource(Rank.class)
    void findMatch(Rank rank) {
        List<Integer> matches = List.of(0, 3, 4, 5, 6);
        assertEquals(rank.findMatch(matches), 1);
    }
}