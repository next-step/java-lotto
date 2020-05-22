package lotto.domain.rank;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.domain.rank.Rank.*;
import static org.assertj.core.api.Assertions.assertThat;

class RankTests {
    @DisplayName("돈을 받을 수 있는 순위인지 알려줄 수 있다.")
    @Test
    void canGetPrizeTest() {
        assertThat(Rank.canGetPrize(FIRST)).isTrue();
        assertThat(Rank.canGetPrize(SIXTH)).isFalse();
    }

    @DisplayName("정적 팩터리 메서드로 등수를 구분할 수 있다.")
    @Test
    void createTest() {
        assertThat(Rank.create(6, false)).isEqualTo(FIRST);
        assertThat(Rank.create(5, false)).isEqualTo(THIRD);
        assertThat(Rank.create(5, true)).isEqualTo(SECOND);
        assertThat(Rank.create(4, true)).isEqualTo(FOURTH);
        assertThat(Rank.create(4, false)).isEqualTo(FOURTH);
    }

    @DisplayName("toString으로 상수의 상태를 표현할 수 있다.")
    @Test
    void rankToStringTest() {
        assertThat(FIRST.toString()).isEqualTo("6개 일치 (2000000000원)");
        assertThat(SECOND.toString()).isEqualTo("5개 일치, 보너스 볼 일치(30000000원)");
        assertThat(THIRD.toString()).isEqualTo("5개 일치 (1500000원)");
    }
}
