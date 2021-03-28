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
}