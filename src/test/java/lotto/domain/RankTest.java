package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RankTest {

        private static Ticket newTicket(int[] numbers) {
                return new Ticket(new LottoNumbers(numbers));
        }

        @Test
        void 보너스_번호_포함_여부에_따른_등수_확인() {
                assertThat(Rank.valueOfRank(5, true)).isEqualTo(Rank.SECOND);
                assertThat(Rank.valueOfRank(5, false)).isEqualTo(Rank.THIRD);
        }

        @ParameterizedTest
        @MethodSource("rankProvider")
        void 당첨번호_및_보너스_번호_갯수에_따라_등수_반환(int matchCount, boolean matchedBonus, Rank rank) {
                assertThat(Rank.valueOfRank(matchCount, matchedBonus)).isEqualTo(rank);
        }

        private static Stream<Arguments> rankProvider() {
                return Stream.of(
                    Arguments.arguments(6, false, Rank.FIRST),
                    Arguments.arguments(5, true, Rank.SECOND),
                    Arguments.arguments(5, false, Rank.THIRD),
                    Arguments.arguments(4, false, Rank.FOURTH),
                    Arguments.arguments(3, false, Rank.FIFTH),
                    Arguments.arguments(0, false, Rank.MISS)
                );
        }
}
