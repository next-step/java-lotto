import Lotto.constants.LottoPrize;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LottoPrizeTest {

    @Test
    void fromMatchCount_ShouldReturnCorrectEnum() {
        assertEquals(LottoPrize.THREE_MATCH, LottoPrize.fromMatchCount(3));
        assertEquals(LottoPrize.FOUR_MATCH, LottoPrize.fromMatchCount(4));
        assertEquals(LottoPrize.FIVE_MATCH, LottoPrize.fromMatchCount(5));
        assertEquals(LottoPrize.SIX_MATCH, LottoPrize.fromMatchCount(6));
    }

    @Test
    void fromMatchCount_ShouldReturnNull_ForInvalidInput() {
        assertNull(LottoPrize.fromMatchCount(2)); // 존재하지 않는 매칭 개수
        assertNull(LottoPrize.fromMatchCount(7)); // 존재하지 않는 매칭 개수
        assertNull(LottoPrize.fromMatchCount(-1)); // 잘못된 입력
    }

    @Test
    void getPrizeMoney_ShouldReturnCorrectValue() {
        assertEquals(5000, LottoPrize.THREE_MATCH.getPrizeMoney());
        assertEquals(50000, LottoPrize.FOUR_MATCH.getPrizeMoney());
        assertEquals(1500000, LottoPrize.FIVE_MATCH.getPrizeMoney());
        assertEquals(2000000000, LottoPrize.SIX_MATCH.getPrizeMoney());
    }
}
