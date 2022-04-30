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
    void wrongInput() {
        assertThatThrownBy(() -> new LottoNumber("1,2,3,4,56,`"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자, 공백 및 , 만 사용 가능합니다.");
    }

    @Test
    @DisplayName("숫자가 6자리가 아니면 예외가 발생한다")
    void wrongSize() {
        assertThatThrownBy(() -> new LottoNumber("1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 6개여야 합니다.");
    }

    @ParameterizedTest
    @DisplayName("1~45 외의 숫자가 있으면 예외가 발생한다")
    @ValueSource(strings = {"0,1,2,3,4,5", "1,2,3,4,5,46"})
    void wrongNumber(String lottoNumber) {
        assertThatThrownBy(() -> new LottoNumber(lottoNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("번호는 1~45만 사용 가능합니다.");
    }
}
