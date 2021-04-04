package step3.domain.winning;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.exception.InputNegativeAmountException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
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

    @DisplayName("WinningStatus 인스턴스 음수 주입시 예외처리 여부 테스트")
    @Test
    void 검증_음수() {
        // given
        int countOfMatch = -1;
        boolean matchBonus = false;

        // when
        assertThatThrownBy(()-> WinningStatus.from(countOfMatch, matchBonus))
                .isInstanceOf(InputNegativeAmountException.class)
                .hasMessageContaining("음수값의 돈이 입력되었습니다.");
    }

    @DisplayName("WinningStatus 인스턴스가 소유한 카운트값 반환 여부 테스트")
    @Test
    void 반환_카운트값() {
        // given
        int expected = 3;
        boolean matchBonus = false;

        // when
        WinningStatus winningStatus = WinningStatus.from(expected, matchBonus);
        int actual = winningStatus.getCountOfMatch();

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("WinningStatus 인스턴스가 소유한 보너스 당첨 상태값 반환 여부 테스트")
    @Test
    void 반환_보너스당첨상태값() {
        // given
        int expected = 3;
        boolean matchBonus = true;

        // when
        WinningStatus winningStatus = WinningStatus.from(expected, matchBonus);
        boolean actual = winningStatus.getMatchBonus();

        assertThat(actual).isTrue();
    }
}