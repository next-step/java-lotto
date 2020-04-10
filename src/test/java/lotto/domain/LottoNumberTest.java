package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class LottoNumberTest {

    @DisplayName("로또 숫자를 생성한다.")
    @Test
    void canCreate() {
         LottoNumber.of(4);
    }

    @DisplayName("로또의 숫자는 1~45 사이에 있어야한다..")
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void testLottoValidate(final int number) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> LottoNumber.of(number));
    }
}
