package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class WinningInformationTest {

    @DisplayName("일치 수에 따라 WinningAmount를 반환한다.")
    @ParameterizedTest
    @MethodSource("generateWinningAmount")
    void count_matches(int matchesCount, WinningInformation winningInformation) {
        assertThat(WinningInformation.of(matchesCount)).isEqualTo(winningInformation);
    }

    private Stream<Arguments> generateWinningAmount() {
        return Stream.of(
                Arguments.arguments(0, WinningInformation.NOT_MATCHES),
                Arguments.arguments(1, WinningInformation.ONE_MATCHES),
                Arguments.arguments(2, WinningInformation.TWO_MATCHES),
                Arguments.arguments(3, WinningInformation.THREE_MATCHES),
                Arguments.arguments(4, WinningInformation.FOUR_MATCHES),
                Arguments.arguments(5, WinningInformation.FIVE_MATCHES),
                Arguments.arguments(6, WinningInformation.SIX_MATCHES),
                Arguments.arguments(7, WinningInformation.NOT_MATCHES)
        );
    }

    @DisplayName("상금의 총 합을 구한다.")
    @Test
    void sum_amounts() {
        List<WinningInformation> winningInformations = Arrays.stream(WinningInformation.values())
                .collect(Collectors.toList());

        BigInteger actual = WinningInformation.sumAmounts(winningInformations);

        assertThat(actual).isEqualTo(BigInteger.valueOf(2_001_555_000));
    }
}