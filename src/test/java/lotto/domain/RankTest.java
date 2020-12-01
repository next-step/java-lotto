package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @Test
    @DisplayName("로또번호와 일치하는 숫자의 개수에 따라 lotto 등수를 반환한다.")
    void should_return_rank() {
        //Given && When && Then
        assertThat(Rank.value(2)).isEqualTo(Rank.FIFTH);
        assertThat(Rank.value(3)).isEqualTo(Rank.FOURTH);
        assertThat(Rank.value(4)).isEqualTo(Rank.THIRD);
        assertThat(Rank.value(5)).isEqualTo(Rank.SECOND);
        assertThat(Rank.value(6)).isEqualTo(Rank.FIRST);
    }

}