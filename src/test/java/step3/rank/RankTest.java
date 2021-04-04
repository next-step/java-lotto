package step3.rank;

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



}