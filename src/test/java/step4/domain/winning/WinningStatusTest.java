package step4.domain.winning;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.exception.InputNegativeAmountException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @DisplayName("WinningStatus 인스턴스 음수 주입시 예외처리 검증 테스트")
    @Test
    void 검증_음수() {
        // given
        int countOfMatch = -1;
        boolean matchBonus = false;

        // when
        assertThatThrownBy(() -> WinningStatus.from(countOfMatch, matchBonus))
                .isInstanceOf(InputNegativeAmountException.class)
                .hasMessageContaining("음수값이 입력되었습니다.");

    }

    @DisplayName("WinningStatus 인스턴스가 소유한 매칭 카운트를 반환하는지 테스트")
    @Test
    void 반환_카운트() {
        // given
        int expected = 3;
        boolean matchBonus = false;

        // when
        WinningStatus winningStatus = WinningStatus.from(expected, matchBonus);
        long actual = winningStatus.getCountOfMatch();

        // then
        assertThat(actual).isEqualTo(expected);

    }

    @DisplayName("WinningStatus 인스턴스가 소유한 보너스점수 여부를 반환하는지 테스트")
    @Test
    void 반환_보너스_boolean() {
        // given
        int expected = 3;
        boolean matchBonus = false;

        // when
        WinningStatus winningStatus = WinningStatus.from(expected, matchBonus);
        boolean actual = winningStatus.getMatchBonus();

        // then
        assertThat(actual).isFalse();

    }
}