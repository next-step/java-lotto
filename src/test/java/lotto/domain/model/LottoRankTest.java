package lotto.domain.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoRankTest {

    @Test
    @DisplayName("일치하는 수의 개수가 1등이다.")
    void valueOf_first() {
        LottoRank first = LottoRank.valueOf(6);
        Assertions.assertThat(first).isEqualTo(LottoRank.FIRST);
    }

    @Test
    @DisplayName("일치하는 수의 개수가 3등이다.")
    void valueOf_third() {
        LottoRank third = LottoRank.valueOf(5);
        Assertions.assertThat(third).isEqualTo(LottoRank.THIRD);
    }

    @Test
    @DisplayName("일치하는 수의 개수가 4등이다.")
    void valueOf_fourth() {
        LottoRank first = LottoRank.valueOf(4);
        Assertions.assertThat(first).isEqualTo(LottoRank.FOURTH);
    }

    @Test
    @DisplayName("일치하는 수의 개수가 5등이다.")
    void valueOf_fifth() {
        LottoRank first = LottoRank.valueOf(3);
        Assertions.assertThat(first).isEqualTo(LottoRank.FIFTH);
    }

    @Test
    @DisplayName("일치하는 수의 개수가 꽝이다.")
    void valueOf_miss() {
        LottoRank first = LottoRank.valueOf(3);
        Assertions.assertThat(first).isEqualTo(LottoRank.FIFTH);
    }
}
