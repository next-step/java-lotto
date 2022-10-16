package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static lotto.domain.WinningInformation.*;
import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class WinningInformationTest {

    @DisplayName("일치 수에 따라 WinningAmount를 반환한다.")
    @ParameterizedTest
    @MethodSource("generateWinningAmount")
    void count_matches(int matchesCount, WinningInformation winningInformation) {
        assertThat(WinningInformation.from(matchesCount)).isEqualTo(winningInformation);
    }


    private Stream<Arguments> generateWinningAmount() {
        return Stream.of(
                Arguments.arguments(0, NOT_MATCHES),
                Arguments.arguments(1, ONE_MATCHES),
                Arguments.arguments(2, TWO_MATCHES),
                Arguments.arguments(3, THREE_MATCHES),
                Arguments.arguments(4, FOUR_MATCHES),
                Arguments.arguments(5, FIVE_MATCHES),
                Arguments.arguments(6, SIX_MATCHES),
                Arguments.arguments(7, NOT_MATCHES)
        );
    }

    @DisplayName("파라미터에 5와 true가 입력되면 FIVE_AND_BONUS_MATCHES를 반환한다.")
    @Test
    void of_matchesCount_isBonusMatch() {
        assertThat(WinningInformation.of(5, true)).isEqualTo(FIVE_AND_BONUS_MATCHES);
    }

    @DisplayName("상금의 총 합을 구한다.")
    @Test
    void sum_amounts() {
        List<WinningInformation> winningInformations = Arrays.stream(WinningInformation.values())
                .collect(Collectors.toList());

        Money actual = WinningInformation.sumAmounts(winningInformations);

        assertThat(actual).isEqualTo(new Money(2_031_555_000));
    }
}
