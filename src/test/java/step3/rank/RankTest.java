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

}