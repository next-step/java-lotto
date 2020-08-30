package step2.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidateUtilTest {

    @DisplayName("당첨 번호와 보너스 번호가 겹치는 경우 예외 테스트")
    @Test
    void invalidBonusNumber_Test() {
        assertThatThrownBy(() -> ValidateUtil.validate(Arrays.asList(1, 2, 3, 4, 5, 6), 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 중복이거나 6개가 아닌 경우 예외 테스트")
    @ParameterizedTest
    @MethodSource("generateLottoData")
    void invalidLottoNumber_Test(List<Integer> input) {
        assertThatThrownBy(() -> ValidateUtil.validate(input, 45))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> generateLottoData() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3)),
                Arguments.of(Arrays.asList(1, 1, 2, 3, 4, 5)),
                Arguments.of(Arrays.asList(1, 1, 2, 3, 4, 5, 6)),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6, 7))
        );
    }
}