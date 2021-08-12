package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RankTest {
    @ParameterizedTest
    @MethodSource
    void 매칭되는_로또번호의_개수와_로또복권의_갯수와_보너스일치여부가_주어지면_당첨금을_알_수_있다(int matchCount, int lottoCount, boolean matchBonus, long expected) {
        Rank rank = Arrays.stream(Rank.values())
            .filter(e -> e == Rank.valueOf(matchCount, matchBonus))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("일치하는 조건이 없습니다."));

        assertThat(rank.money()
            .multiply(lottoCount)
            .amount()).isEqualTo(expected);
    }

    private static Stream<Arguments> 매칭되는_로또번호의_개수와_로또복권의_갯수와_보너스일치여부가_주어지면_당첨금을_알_수_있다() {
        return Stream.of(
                Arguments.of(0, 1, false, 0L),
                Arguments.of(3, 1, false, 5_000L),
                Arguments.of(4, 1, false, 50_000L),
                Arguments.of(5, 1, false, 1_500_000L),
                Arguments.of(5, 1, true,  30_000_000L),
                Arguments.of(6, 1, false, 2_000_000_000L),
                Arguments.of(3, 2, false, 10_000L),
                Arguments.of(4, 2, false, 100_000L),
                Arguments.of(5, 2, false, 3_000_000L),
                Arguments.of(5, 2, true,  60_000_000L),
                Arguments.of(6, 2, false, 4_000_000_000L)
        );
    }

    @ParameterizedTest
    @MethodSource
    void Rank_Enum클래스의_정적메소드_valueOf의_입력값의_여러케이스가_주어지면_조건에_맞는_Rank변수를_반환한다
            (int countOfMatch, boolean matchBonus, Rank expected) {
        assertThat(Rank.valueOf(countOfMatch, matchBonus)).isEqualTo(expected);
    }

    private static Stream<Arguments> Rank_Enum클래스의_정적메소드_valueOf의_여러케이스가_주어지면_조건에_맞는_Rank변수를_반환한다() {
        return Stream.of(
                Arguments.of(6, false, Rank.FIRST),
                Arguments.of(5, true,  Rank.SECOND),
                Arguments.of(5, false, Rank.THIRD),
                Arguments.of(4, false, Rank.FOURTH),
                Arguments.of(3, false, Rank.FIFTH),
                Arguments.of(2, false, Rank.MISS),
                Arguments.of(1, false, Rank.MISS),
                Arguments.of(0, false, Rank.MISS)
        );
    }
}
