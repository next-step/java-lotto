package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LottoNumberTest {

    @DisplayName("생성")
    @Test
    void create() {
        LottoNumber lottoNumber = new LottoNumber(5);
        assertAll(
                () -> assertThat(lottoNumber).isEqualTo(new LottoNumber(5)),
                () -> assertThat(lottoNumber).isEqualTo(new LottoNumber("5"))
        );
    }

    @DisplayName("숫자가 아닌 값 입력시 IllegalArgumentException 발생")
    @Test
    void create_ThrowsIllegalArgumentException_IfInputIsNotInteger() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new LottoNumber("abc")
        );
    }

    @DisplayName("로또 숫자 범위 외 값 입력시 IllegalArgumentException 발생")
    @ParameterizedTest(name = "{index}. {displayName}, arguments: {arguments}")
    @ValueSource(ints = {0, 46, -5})
    void create_ThrowsIllegalArgumentException_IfInputIsOutOfLottoNumberRange(int input) {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new LottoNumber(input));
    }
}
