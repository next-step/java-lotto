package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WinningInfosTest {

    @Test
    @DisplayName("순위 정보를 업데이트 시킨다.")
    void updateTest() throws ClassNotFoundException {
        WinningInfos winningInfos = WinningInfos.of();
        winningInfos.update(Rank.FIRST);

        WinningInfo winningInfo = winningInfos.getWinningInfos().stream()
                .filter(e -> e.getRank().equals(Rank.FIRST))
                .findFirst()
                .orElseThrow(ClassNotFoundException::new);

        assertThat(winningInfo.getWinningNumber()).isEqualTo(1);
    }


}