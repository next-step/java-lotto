package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class RankTest {
    @DisplayName("로또 당첨 테스트")
    @ParameterizedTest
    @MethodSource("lottoRank")
    void 로또_당첨_테스트(int count, Money money, boolean isWin) {
        Rank rank = Rank.of(count, isWin);
        Assertions.assertThat(rank.prize()).isEqualTo(money.amount());
    }

    private static Stream<Arguments> lottoRank() {
        return Stream.of(
                Arguments.of(6, new Money(2_000_000_000), true),
                Arguments.of(5, new Money(0), false),
                Arguments.of(4, new Money(0), false),
                Arguments.of(3, new Money(5_000), true)
        );
    }

}
