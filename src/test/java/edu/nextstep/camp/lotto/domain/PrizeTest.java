package edu.nextstep.camp.lotto.domain;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PrizeTest {
    @ParameterizedTest(name = "create: {arguments}")
    @ValueSource(longs = {0, 1, Integer.MAX_VALUE, 4000000000L})
    public void create(long prize) {
        assertThat(Prize.of(prize)).isEqualTo(Prize.of(prize));
        assertThat(Prize.of(prize).toLong()).isEqualTo(prize);
    }

    @Test
    public void createFixedPlace() {
        assertThat(Prize.ofFirstPlace(1)).isEqualTo(Prize.FIRST_PRIZE);
        assertThat(Prize.ofSecondPlace(1)).isEqualTo(Prize.SECOND_PRIZE);
        assertThat(Prize.ofThirdPlace(1)).isEqualTo(Prize.THIRD_PRIZE);
        assertThat(Prize.ofFourthPlace(1)).isEqualTo(Prize.FOURTH_PRIZE);
    }

    @ParameterizedTest(name = "create failed: {arguments}")
    @ValueSource(longs = {-1})
    public void createFailed(long prize) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Prize.of(prize))
                .withMessageContaining("can not be smaller than 0.");
    }

    static Stream<Arguments> parseMultiplyWith2() {
        return Stream.of(
                Arguments.of(0, 0),
                Arguments.of(1, 2),
                Arguments.of(Integer.MAX_VALUE, Integer.MAX_VALUE * 2L),
                Arguments.of(2000000000L, 4000000000L)
        );
    }

    @ParameterizedTest(name = "add: {0} + {0} = {1}")
    @MethodSource("parseMultiplyWith2")
    public void add(long input, long expected) {
        assertThat(Prize.of(input).add(Prize.of(input))).isEqualTo(Prize.of(expected));
    }

    @ParameterizedTest(name = "multiply: {0} * 2 = {1}")
    @MethodSource("parseMultiplyWith2")
    public void multiply(long input, long expected) {
        assertThat(Prize.of(input).multiply(2)).isEqualTo(Prize.of(expected));
    }
}
