package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RankTest {

    @Test
    @DisplayName("매칭된 번호 갯수에 따른 등수 체크")
    public void rankCheck() {
        assertEquals(Rank.getRank(6), Rank.FIRST);
        assertEquals(Rank.getRank(5), Rank.SECOND);
        assertEquals(Rank.getRank(4), Rank.THIRD);
        assertEquals(Rank.getRank(3), Rank.FOURTH);
        assertEquals(Rank.getRank(2), Rank.NOT_MATCH);
        assertEquals(Rank.getRank(1), Rank.NOT_MATCH);
        assertEquals(Rank.getRank(0), Rank.NOT_MATCH);
    }
}
