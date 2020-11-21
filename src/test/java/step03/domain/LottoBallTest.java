package step03.domain;

import exception.OutOfLottoNumberRangeException;
import exception.OutOfLottoNumberRangeExceptionTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoBallTest {

    @DisplayName("생성자")
    @Test
    void test_constructor() {
        assertThat(LottoBall.of(1)).isEqualTo(LottoBall.of(1));
    }

    private static Stream<Integer> provideOutOfRangeResult() {
        return Stream.of(
                -1, 0, 46
        );
    }

    @DisplayName("OutOfRange 예외 던짐")
    @ParameterizedTest
    @MethodSource("provideOutOfRangeResult")
    void test_validate(int number) {
        assertThatExceptionOfType(OutOfLottoNumberRangeException.class)
                .isThrownBy(() -> {
                    LottoBall.of(number);
                });
    }

}
