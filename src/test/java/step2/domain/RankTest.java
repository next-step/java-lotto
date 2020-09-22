package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RankTest {

    @Test
    @DisplayName("1등 체크")
    public void checkFirstRank() {
        assertEquals(Rank.getRank(6, false), Rank.FIRST);
    }

    @Test
    @DisplayName("2등 체크")
    public void checkSecondRank() {
        assertEquals(Rank.getRank(5, true), Rank.SECOND);
    }

    @Test
    @DisplayName("3등 체크")
    public void checkThirdRank() {
        assertEquals(Rank.getRank(5, false), Rank.THIRD);
    }

    @Test
    @DisplayName("4등 체크")
    public void checkFourthRank() {
        assertEquals(Rank.getRank(4, true), Rank.FOURTH);
    }

    @Test
    @DisplayName("5등 체크")
    public void checkFifthRank() {
        assertEquals(Rank.getRank(3, true), Rank.FIFTH);
    }

    @Test
    @DisplayName("꽝 체크")
    public void checkNotMatchRank() {
        assertEquals(Rank.getRank(2, true), Rank.NOT_MATCH);
    }
}
