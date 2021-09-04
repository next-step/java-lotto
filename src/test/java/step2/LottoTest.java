package step2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {
//    @Test
//    void createLottoNumber() {
//        final Lotto lotto = new Lotto();
//        System.out.println(lotto);
//    }

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

    @Test
    void createLottoNumbersSuccessTest() {
        final LottoNumbers actual = new LottoNumbers(() -> 1);
        final LottoNumbers expected = new LottoNumbers(Arrays.asList(1, 1, 1, 1, 1, 1));
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void createLottoNumbersFailTest() {
        assertThatThrownBy(() -> new LottoNumbers(Arrays.asList(1, 1, 1, 1, 1, 1, 1)))
                .isExactlyInstanceOf(RuntimeException.class)
                .hasMessage("로또 숫자는 최대 6개 입니다.");
    }
}
