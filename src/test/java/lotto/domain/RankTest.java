package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RankTest {

    @DisplayName("Rank의 정적 팩토리 메서드는")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    class Describe_valueOf {

        @DisplayName("일치하는 숫자의 개수에 따른 등수를 반환한다.")
        @ParameterizedTest(name = "{index}번째 테스트: 숫자가 {0}개 일치하면 {1}")
        @MethodSource("rankByMatchCount")
        void it_returns_rank_when_less_than_six(int matchCount, Rank expectedRank) {
            assertThat(Rank.valueOf(matchCount)).isEqualTo(expectedRank);
        }

        @DisplayName("로또의 최대 숫자 개수보다 큰 숫자를 입력하면, IllegalArgumentException을 던진다.")
        @Test
        void it_throws_illegalArgumentException_when_greater_than_six() {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> Rank.valueOf(7));
        }

        Stream<Arguments> rankByMatchCount() {
            return Stream.of(
                    Arguments.of(0, Rank.NEXT_CHANCE),
                    Arguments.of(1, Rank.NEXT_CHANCE),
                    Arguments.of(2, Rank.NEXT_CHANCE),
                    Arguments.of(3, Rank.FIFTH),
                    Arguments.of(4, Rank.FOURTH),
                    Arguments.of(5, Rank.SECOND),
                    Arguments.of(6, Rank.FIRST)
            );
        }

    }

}
