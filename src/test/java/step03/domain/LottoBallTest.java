package step03.domain;

import exception.OutOfLottoNumberRangeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoBallTest {

    private static Stream<Arguments> provideLottoBallResult() {
        return Stream.of(
                Arguments.of(LottoBall.valueOf(1), LottoBall.valueOf(1), true),
                Arguments.of(LottoBall.valueOf(1), LottoBall.valueOf(2), false)
        );
    }

    @DisplayName("캐싱 테스트")
    @ParameterizedTest
    @MethodSource("provideLottoBallResult")
    void test_valueOf(LottoBall ballA, LottoBall ballB, boolean expect) {
        assertThat(ballA == ballB).isEqualTo(expect);
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
                    LottoBall.valueOf(number);
                });
    }

}
