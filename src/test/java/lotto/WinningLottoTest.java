package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class WinningLottoTest {

    @Test
    @DisplayName("당첨 로또를 생성하는데 어떤 예외도 발생하지 않는다.")
    void 로또_당첨_번호_생성_테스트() {
        assertThatCode(() -> WinningLotto.of(new int[]{1, 2, 3, 4, 5, 6})).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("당첨 로또를 생성하는데 크기가 6보다 작으면 예외가 발생한다.")
    void 로또_당첨_번호_예외_테스트() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> WinningLotto.of(new int[]{1, 2, 3, 4, 5}));
    }

    @Test
    @DisplayName("당첨 로또를 생성하는데 크기가 6보다 작으면 예외가 발생한다.")
    void 로또_당첨_번호_중복_예외_테스트() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> WinningLotto.of(new int[]{1, 2, 3, 4, 5, 5}));
    }

    @MethodSource("generate_lotto_numbers")
    @ParameterizedTest
    @DisplayName("당첨 로또를 생성하는데 크기가 숫자가 1보다 작거나 45보다 크면 예외가 발생한다.")
    void 로또_당첨_번호_범위_예외_테스트(int[] lottoNumbers) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> WinningLotto.of(lottoNumbers));
    }

    private static Stream<Arguments> generate_lotto_numbers() {
        return Stream.of(
                Arguments.of(new int[]{1, 46, 2, 3, 4, 5}),
                Arguments.of(new int[]{0, 45, 2, 3, 4, 5})
        );
    }
}
