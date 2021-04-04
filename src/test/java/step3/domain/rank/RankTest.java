package step3.domain.rank;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RankTest {

    @DisplayName("Rank 열거형 생성 여부 테스트")
    @Test
    void 생성() {
        assertAll(
                () -> assertThat(Rank.MISS).isNotNull(),
                () -> assertThat(Rank.FIFTH).isNotNull(),
                () -> assertThat(Rank.FOURTH).isNotNull(),
                () -> assertThat(Rank.THIRD).isNotNull(),
                () -> assertThat(Rank.SECOND).isNotNull(),
                () -> assertThat(Rank.FIRST).isNotNull()
        );
    }

    @DisplayName("Rank 열거형 첫번째 열거값 반환 여부 테스트")
    @Test
    void 반환_첫번째열거값() {
        assertAll(
                () -> assertThat(Rank.MISS.getCountOfMatch()).isEqualTo(0),
                () -> assertThat(Rank.FIFTH.getCountOfMatch()).isEqualTo(3),
                () -> assertThat(Rank.FOURTH.getCountOfMatch()).isEqualTo(4),
                () -> assertThat(Rank.THIRD.getCountOfMatch()).isEqualTo(5),
                () -> assertThat(Rank.SECOND.getCountOfMatch()).isEqualTo(5),
                () -> assertThat(Rank.FIRST.getCountOfMatch()).isEqualTo(6)
        );
    }

    @DisplayName("Rank 열거형 두번째 열거값 반환 여부 테스트")
    @Test
    void 반환_두번째열거값() {
        assertAll(
                () -> assertThat(Rank.MISS.getWinningMoney()).isEqualTo(0),
                () -> assertThat(Rank.FIFTH.getWinningMoney()).isEqualTo(5_000),
                () -> assertThat(Rank.FOURTH.getWinningMoney()).isEqualTo(50_000),
                () -> assertThat(Rank.THIRD.getWinningMoney()).isEqualTo(1_500_000),
                () -> assertThat(Rank.SECOND.getWinningMoney()).isEqualTo(30_000_000),
                () -> assertThat(Rank.FIRST.getWinningMoney()).isEqualTo(2_000_000_000)
        );
    }

    @DisplayName("Rank 열거형 알맞는 열거값 반환 여부 테스트")
    @Test
    void 반환_알맞는열거값반환() {
        assertAll(
                () -> assertThat(Rank.valueOf(0, false)).isEqualTo(Rank.MISS),
                () -> assertThat(Rank.valueOf(3, false)).isEqualTo(Rank.FIFTH),
                () -> assertThat(Rank.valueOf(4, false)).isEqualTo(Rank.FOURTH),
                () -> assertThat(Rank.valueOf(5, false)).isEqualTo(Rank.THIRD),
                () -> assertThat(Rank.valueOf(5, true)).isEqualTo(Rank.SECOND),
                () -> assertThat(Rank.valueOf(6, false)).isEqualTo(Rank.FIRST)
        );
    }

}