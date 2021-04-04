package step3.domain.winning;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WinningCheckMachineTest {

    @DisplayName("WinningCheckMachine 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {
        // when
        WinningCheckMachine winningCheckMachine = WinningCheckMachine.getInstance();

        // then
        assertThat(winningCheckMachine).isNotNull();
    }

    @DisplayName("WinningCheckMachine 인스턴스가 WinningResult 인스턴스 반환 여부 테스트")
    @Test
    void 반환() {
        // when
        WinningCheckMachine winningCheckMachine = WinningCheckMachine.getInstance();
        WinningResult winningResult = winningCheckMachine.getWinningResult();

        // then
        assertThat(winningResult).isNotNull();
    }

}