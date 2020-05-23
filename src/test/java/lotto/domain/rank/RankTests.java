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

    @DisplayName("당첨 등수가 2등인지를 알려줄 수 있다.")
    @Test
    void isSecondTest() {
        assertThat(SECOND.isSecond()).isTrue();
        assertThat(THIRD.isSecond()).isFalse();
    }
}
