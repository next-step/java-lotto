package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {
    @Test
    @DisplayName("숫자, 문자 , 외 입력시 예외가 발생한다")
    void wrongInputException() {
        assertThatThrownBy(() -> new LottoNumber("1,2,3,4,56,`"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자, 공백 및 , 만 사용 가능합니다.");
    }

    @Test
    @DisplayName("숫자가 6자리가 아니면 예외가 발생한다")
    void wrongSizeException() {
        assertThatThrownBy(() -> new LottoNumber("1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 6개여야 합니다.");
    }

    @ParameterizedTest
    @DisplayName("중복된 번호가 있으면 예외가 발생한다")
    @ValueSource(strings = {"1,2,3,4,5,5"})
    void wrongNumberException(String lottoNumber) {
        assertThatThrownBy(() -> new LottoNumber(lottoNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 번호가 있습니다.");
    }
}
