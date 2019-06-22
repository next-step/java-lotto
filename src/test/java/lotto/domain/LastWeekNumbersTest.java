package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LastWeekNumbersTest {

    @Test
    void parse() {

        LastWeekNumbers lastWeekNumbers = new LastWeekNumbers("1, 2, 3, 4, 5, 6");
        assertThat(lastWeekNumbers).isEqualTo(new LastWeekNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @ParameterizedTest
    @MethodSource
    @NullAndEmptySource
    void parseIllegalArgumentException(List<Integer> lastWeekNumbers) {

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LastWeekNumbers(lastWeekNumbers));
    }

    private static Stream<Arguments> parseIllegalArgumentException() {

        return Stream.of(
                Arguments.of(IntStream.rangeClosed(1, 5).boxed().collect(Collectors.toList())),
                Arguments.of(IntStream.rangeClosed(1, 7).boxed().collect(Collectors.toList()))
        );
    }
}