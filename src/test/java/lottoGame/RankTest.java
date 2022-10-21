package lottoGame;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RankTest {

    @ParameterizedTest
    @EnumSource(Rank.class)
    void findMatch(Rank rank) {
        int match = 5;
        assertEquals(rank.findRank(match, false), Rank.THIRD);
    }
}