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
    void 매칭되는_로또번호의_개수와_로또복권의_갯수가_주어지면_당첨금을_알_수_있다(int matchCount, int lottoCount, long expected) {
        Rank rank = Arrays.stream(Rank.values())
            .filter(e -> matchCount == e.getMatchCount())
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("일치하는 조건이 없습니다."));

        assertThat(rank.getMoney()
            .multiply(lottoCount)
            .amount()).isEqualTo(expected);
    }

    private static Stream<Arguments> 매칭되는_로또번호의_개수와_로또복권의_갯수가_주어지면_당첨금을_알_수_있다() {
        return Stream.of(
            Arguments.of(0, 1, 0L),
            Arguments.of(3, 1, 5000L),
            Arguments.of(4, 1, 50000L),
            Arguments.of(5, 1, 1500000L),
            Arguments.of(6, 1, 2_000_000_000L),
            Arguments.of(3, 2, 10000L),
            Arguments.of(4, 2, 100000L),
            Arguments.of(5, 2, 3_000_000L),
            Arguments.of(6, 2, 4_000_000_000L)
        );
    }


}
