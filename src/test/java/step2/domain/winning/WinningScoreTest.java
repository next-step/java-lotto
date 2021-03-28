package step2.domain.winning;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WinningScoreTest {

    @DisplayName("WinningScore 생성 테스트")
    @Test
    void 생성() {

        assertAll(
                () -> assertThat(WinningScore.MISS).isNotNull(),
                () -> assertThat(WinningScore.THREE).isNotNull(),
                () -> assertThat(WinningScore.FOUR).isNotNull(),
                () -> assertThat(WinningScore.FIVE).isNotNull(),
                () -> assertThat(WinningScore.SIX).isNotNull()
        );

    }

    @DisplayName("WinningScore 값 반환 테스트")
    @Test
    void 반환_값() {

        assertAll(
                () -> assertThat(WinningScore.MISS.getWinningAmount()).isEqualTo(0),
                () -> assertThat(WinningScore.THREE.getWinningAmount()).isEqualTo(5_000),
                () -> assertThat(WinningScore.FOUR.getWinningAmount()).isEqualTo(50_000),
                () -> assertThat(WinningScore.FIVE.getWinningAmount()).isEqualTo(1_500_000),
                () -> assertThat(WinningScore.SIX.getWinningAmount()).isEqualTo(1_500_000)
        );

    }

    @DisplayName("WinningScore 값 반환 테스트")
    @Test
    void 반환_맞은갯수() {

        assertAll(
                () -> assertThat(WinningScore.MISS.getCorrectCount()).isEqualTo(0),
                () -> assertThat(WinningScore.THREE.getCorrectCount()).isEqualTo(3),
                () -> assertThat(WinningScore.FOUR.getCorrectCount()).isEqualTo(4),
                () -> assertThat(WinningScore.FIVE.getCorrectCount()).isEqualTo(5),
                () -> assertThat(WinningScore.SIX.getCorrectCount()).isEqualTo(6)
        );

    }

}