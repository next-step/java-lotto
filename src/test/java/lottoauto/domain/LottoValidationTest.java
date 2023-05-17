package lottoauto.domain;

import java.util.List;
import java.util.stream.Stream;
import lottoauto.model.LottoNumberValidation;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LottoValidationTest {

    @ParameterizedTest
    @MethodSource("LottoValidationArgument")
    void generateLottoValidationTest(List<Integer> numbers, int bonusNumber, Class clazz, String message) {
        Assertions.assertThatThrownBy(() -> LottoNumberValidation.checkWinningLotto(numbers, bonusNumber))
                .isInstanceOf(clazz)
                .hasMessage(message);

    }

    private static Stream<Arguments> LottoValidationArgument() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 66), 20, IllegalArgumentException.class, "로또 숫자는 1에서 45사이의 숫자여야 합니다."),
                Arguments.of(List.of(1, 2, 3, 4, 5), 20, IllegalStateException.class, "로또의 숫자가 6개가 아닙니다."),
                Arguments.of(List.of(1, 2, 3, 4, 5, 5), 20, IllegalStateException.class, "중복되는 숫자가 있습니다."),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 6, IllegalArgumentException.class, "보너스 숫자가 당첨 숫자에 포함되어 있습니다."),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 67, IllegalArgumentException.class, "보너스 숫자는 1~45까지의 숫자를 입력해야 합니다.")
        );
    }

}
