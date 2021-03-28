package step2.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankTest {

    @DisplayName("2등 테스트")
    @Test
    void second() {
        Rank rank = Rank.valueOf(5, true);
        assertEquals(rank, Rank.SECOND);
    }

    @DisplayName("5개일치(2등아님) 테스트")
    @Test
    void third() {
        Rank rank = Rank.valueOf(5, false);
        assertEquals(rank, Rank.THIRD);
    }
}