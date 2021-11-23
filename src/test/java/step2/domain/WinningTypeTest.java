package step2.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
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
        WinningType winningType = WinningType.findBy(matchCount, false);
        //then
        assertEquals(winningType.getWinnings(), 5000);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 1, 2})
    void 지정된_당첨_개수가_존재하지_않으면_IllegalArgumentException_이_발생한다(int matchCount) {
        //given
        //when
        //then
        assertThatThrownBy(() -> WinningType.findBy(matchCount, false))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
