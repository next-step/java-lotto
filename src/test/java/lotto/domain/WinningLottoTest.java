package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinningLottoTest {

    private static Stream<Arguments> 유효한_당첨_번호인_경우() {
        return Stream.of(
            Arguments.of(7, Arrays.asList(1, 2, 3, 4, 5, 6)),
            Arguments.of(3, Arrays.asList(2, 34, 5, 23, 18, 9))
        );
    }

    @ParameterizedTest
    @MethodSource
    void 유효한_당첨_번호인_경우(int number, List<Integer> numbers) {
        assertThat(number).isEqualTo(
            new WinningLotto(numbers, number).getBonusNumber().getNumber());
    }

    private static Stream<Arguments> 당첨_번호와_중복되는_경우() {
        return Stream.of(
            Arguments.of(7, Arrays.asList(1, 2, 3, 4, 5, 7)),
            Arguments.of(3, Arrays.asList(2, 34, 5, 3, 18, 9))
        );
    }

    @ParameterizedTest
    @MethodSource
    void 당첨_번호와_중복되는_경우(int number, List<Integer> numbers) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new WinningLotto(numbers, number))
            .withMessage("[ERROR] 당첨 번호와 중복된 값입니다. 다시 입력해주세요.");
    }
}
