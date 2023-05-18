package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {
    @DisplayName("로또 당첨 테스트")
    @ParameterizedTest
    @MethodSource("lottoRank")
    void 로또_당첨_테스트(int count, Money money, boolean hasBonusBall) {
        Rank rank = Rank.findByCount(count, hasBonusBall);
        assertThat(rank.prize()).isEqualTo(money.amount());
    }

    private static Stream<Arguments> lottoRank() {
        return Stream.of(
                Arguments.of(6, new Money(2_000_000_000), false),
                Arguments.of(5, new Money(30_000_000), true),
                Arguments.of(4, new Money(1_500_000), true),
                Arguments.of(3, new Money(5_000), true)
        );
    }

    @DisplayName("2등 보너스번호 없는경우 테스트")
    @Test
    void 보너스번호_없는_2등당첨_테스트() {
        Rank rank = Rank.findByCount(5, false);
        assertThat(rank.prize()).isEqualTo(Rank.SECOND.prize());
    }

    @DisplayName("2등 보너스번호 당첨 테스트")
    @Test
    void 보너스번호_2등당첨_테스트() {
        Rank rank = Rank.findByCount(5, true);
        assertThat(rank.prize()).isEqualTo(Rank.BONUS_RANK.prize());
    }
}
