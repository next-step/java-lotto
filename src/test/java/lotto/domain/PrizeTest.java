package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class PrizeTest {

    @DisplayName("당첨 일치 갯수와 당첨 금액을 리턴한다.")
    @ParameterizedTest
    @MethodSource("paramsForPrize")
    void matchPrize(Prize prize, int match, boolean bonusNumber, int amount) {
        assertAll(
                () -> assertThat(prize).isEqualTo(Prize.of(match, bonusNumber)),
                () -> assertThat(prize.getAmount()).isEqualTo(amount)
        );
    }

    private static Stream<Arguments> paramsForPrize() {
        return Stream.of(
                Arguments.of(Prize.FIRST, 6, false, 2000_000_000),
                Arguments.of(Prize.SECOND, 5, true, 30_000_000),
                Arguments.of(Prize.THIRD, 5, false, 150_0000),
                Arguments.of(Prize.FOURTH, 4, false, 50_000),
                Arguments.of(Prize.FIFTH, 3, false, 5000),
                Arguments.of(Prize.MISS, 0, false, 0)
        );
    }
}
