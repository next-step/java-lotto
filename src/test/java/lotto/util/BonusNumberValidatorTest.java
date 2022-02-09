package lotto.util;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.domain.lotto.number.Number;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BonusNumberValidatorTest {

    @ParameterizedTest
    @MethodSource
    void 당첨_번호와_중복되는_경우(int number, List<Integer> numbers) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(
                () -> BonusNumberValidator.validateDuplicateBonus(number, numbers.stream().map(
                    Number::new).collect(Collectors.toList())))
            .withMessage("[ERROR] 당첨 번호와 중복된 값입니다. 다시 입력해주세요.");
    }

    private static Stream<Arguments> 당첨_번호와_중복되는_경우() {
        return Stream.of(
            Arguments.of(7, Arrays.asList(1, 2, 3, 4, 5, 7)),
            Arguments.of(3, Arrays.asList(2, 34, 5, 3, 18, 9))
        );
    }
}
