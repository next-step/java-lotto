package lotto;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.game.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumberTest {

    @DisplayName("1이상 45이하의 숫자가 아니면 에러가 발생한다")
    @ValueSource(ints = {0, 46})
    @ParameterizedTest()
    void 로또_번호_검증_실패_범위(int value) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new LottoNumber(value))
            .withMessage("1이상 45이하의 숫자여야합니다");
    }

    @DisplayName("1이상 45이하의 숫자면 에러가 발생하지 않는다")
    @ValueSource(ints = {1, 45, 23})
    @ParameterizedTest()
    void 로또_번호_검증_성공(int value) {
        assertThatNoException()
            .isThrownBy(() -> new LottoNumber(value));
    }

    @DisplayName("숫자가 아니면 예외처리 발생")
    @ValueSource(strings = {"가", "나", "다"})
    @ParameterizedTest()
    void 로또_번호_문자_예외(String text) {
        assertThatThrownBy(() -> new LottoNumber(text))
            .isInstanceOf(NumberFormatException.class)
            .withFailMessage("숫자를 입력해 주세요");
    }

}
