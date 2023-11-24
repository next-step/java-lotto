package lottoModel;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RankTest {

    @Test
    @DisplayName("매치갯수 테스트")
    void getCountOfMatch() {
        assertEquals(6, Rank.FIRST.getCountOfMatch());
        assertEquals(5, Rank.SECOND.getCountOfMatch());
    }

    @Test
    @DisplayName("당첨금액 테스트")
    void getWinningMoney() {
        assertEquals(2_000_000_000, Rank.FIRST.getWinningMoney());
        assertEquals(30_000_000, Rank.SECOND.getWinningMoney());
    }

    @Test
    @DisplayName("보너스 당침 테스트")
    void valueOfWithMatchBonus() {
        assertEquals(Rank.SECOND, Rank.valueOf(5, true));
    }

    @Test
    @DisplayName("보너스 번호 당텀 외 기타 등수별 테스트")
    void valueOfWithoutMatchBonus() {
        assertEquals(Rank.FIRST, Rank.valueOf(6, false));
        assertEquals(Rank.THIRD, Rank.valueOf(5, false));
        assertEquals(Rank.FOURTH, Rank.valueOf(4, false));
        assertEquals(Rank.FIFTH, Rank.valueOf(3, false));
        assertEquals(Rank.MISS, Rank.valueOf(2, false));

    }
}
