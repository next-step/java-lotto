package step2.domain.lotto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 45})
    void createLottoNumberSuccessTest(int inputNumber) {
        final LottoNumber lottoNumber = new LottoNumber(inputNumber);
        final LottoNumber expected = new LottoNumber(inputNumber);
        assertThat(lottoNumber).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void createLottoNumberFailTest(int inputNumber) {
        assertThatThrownBy(() -> new LottoNumber(inputNumber))
                .isExactlyInstanceOf(RuntimeException.class)
                .hasMessage("1~45 사이의 숫자만 생성 가능합니다.");
    }
}
