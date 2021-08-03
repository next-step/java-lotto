package lotto.domain.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

public class LottoRankTest {

    @Test
    @DisplayName("일치하는 수의 개수가 1등이다.")
    void of_first() {
        LottoRank first = LottoRank.of(6);
        assertThat(first).isEqualTo(LottoRank.FIRST);
    }

    @Test
    @DisplayName("일치하는 수의 개수가 3등이다.")
    void of_third() {
        LottoRank third = LottoRank.of(5);
        assertThat(third).isEqualTo(LottoRank.THIRD);
    }

    @Test
    @DisplayName("일치하는 수의 개수가 4등이다.")
    void of_fourth() {
        LottoRank first = LottoRank.of(4);
        assertThat(first).isEqualTo(LottoRank.FOURTH);
    }

    @Test
    @DisplayName("일치하는 수의 개수가 5등이다.")
    void of_fifth() {
        LottoRank first = LottoRank.of(3);
        assertThat(first).isEqualTo(LottoRank.FIFTH);
    }

    @Test
    @DisplayName("일치하는 수의 개수가 꽝이다.")
    void of_miss() {
        LottoRank first = LottoRank.of(3);
        assertThat(first).isEqualTo(LottoRank.FIFTH);
    }

    @ParameterizedTest
    @EnumSource(
            value = LottoRank.class,
            names = {"MISS"},
            mode = EnumSource.Mode.EXCLUDE)
    void isNotMiss_true(LottoRank lottoRank) {
        assertThat(lottoRank.isNotMiss()).isTrue();
    }

    @Test
    @DisplayName("MISS 등급은 MISS 등급이 아니라고 인지한다.")
    void isNotMiss_false() {
        assertThat(LottoRank.MISS.isNotMiss()).isFalse();
    }
}
