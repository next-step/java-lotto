package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    private static final Lotto WINNING_LOTTO =
            new Lotto(List.of(1, 2, 3, 4, 5, 6));

    @ParameterizedTest(name = "로또는 중복 없이 1 ~ 45의 숫자 6개를 가진다.")
    @MethodSource("provideInvalidLottoNumbers")
    void validation(List<Integer> invalidNumbers) {
        assertThatThrownBy(() -> new Lotto(invalidNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<List<Integer>> provideInvalidLottoNumbers() {
        return Stream.of(
                List.of(1),
                List.of(1, 2, 3, 4, 5, 6, 7),
                List.of(0, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 46),
                List.of(1, 1, 2, 3, 4, 5)
        );
    }

    @ParameterizedTest(name = "로또 두 개 비교해서 상금 반환")
    @MethodSource("provideArgumentsForEarnings")
    void earnings(Lotto lotto, double earning) {
        assertThat(lotto.earnings(WINNING_LOTTO))
                .isEqualTo(earning);
    }

    private static Stream<Arguments> provideArgumentsForEarnings() {
        return Stream.of(
                Arguments.of(new Lotto(List.of(7, 8, 9, 10, 11, 12)), Prize.findEarningsByMatchCount(0)),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 7)), Prize.findEarningsByMatchCount(5)),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), Prize.findEarningsByMatchCount(6))
        );
    }

    @ParameterizedTest(name = "로또 두 개 비교해서 일치하는 숫자 개수 반환")
    @MethodSource("provideArgumentsForMatchCount")
    void matchCount(Lotto lotto, int matchCount) {
        assertThat(lotto.matchCount(WINNING_LOTTO))
                .isEqualTo(matchCount);
    }

    private static Stream<Arguments> provideArgumentsForMatchCount() {
        return Stream.of(
                Arguments.of(new Lotto(List.of(7, 8, 9, 10, 11, 12)), 0),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 7)), 5),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 6)
        );
    }
}
