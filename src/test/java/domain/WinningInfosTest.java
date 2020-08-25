package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

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

    @Test
    @DisplayName("총 당첨금을 반환한다.")
    void getTotalWinningMoney() {
        WinningInfos winningInfos = WinningInfos.of();
        winningInfos.update(Rank.FIRST);
        winningInfos.update(Rank.SECOND);
        winningInfos.update(Rank.THIRD);
        BigDecimal totalWinningMoney = winningInfos.getTotalWinningMoney();

        BigDecimal expected = Rank.FIRST.getWinningMoney()
                .add(Rank.SECOND.getWinningMoney())
                .add(Rank.THIRD.getWinningMoney());

        assertThat(totalWinningMoney).isEqualTo(expected);
    }



}