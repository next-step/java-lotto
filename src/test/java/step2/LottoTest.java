package step2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {
    @Test
    void createLottoNumber() {
        final Lotto lotto = new Lotto();
        System.out.println(lotto);
    }

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
                .isExactlyInstanceOf(RuntimeException.class);
    }
}
