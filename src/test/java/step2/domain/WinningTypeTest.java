package step2.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class WinningTypeTest {
    
    @Test
    void 당첨_타입을_생성한다() {
        assertNotNull(WinningType.FIRST);
        assertNotNull(WinningType.SECOND);
        assertNotNull(WinningType.THIRD);
        assertNotNull(WinningType.FOURTH);
    }

    @Test
    void 당첨_개수_3개면_당첨금은_5000원_이다() {
        //given
        int matchCount = 3;
        //when
        WinningType winningType = WinningType.findBy(matchCount);
        //then
        assertEquals(winningType.getWinnings(), 5000);
    }
}
