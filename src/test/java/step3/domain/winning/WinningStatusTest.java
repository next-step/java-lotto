package step3.domain.winning;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WinningStatusTest {

    @DisplayName("WinningStatus 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {
        // given
        int countOfMatch = 3;
        boolean matchBonus = false;

        // when
        WinningStatus winningStatus = WinningStatus.from(countOfMatch, matchBonus);

        // then
        assertThat(winningStatus).isNotNull();
    }
}