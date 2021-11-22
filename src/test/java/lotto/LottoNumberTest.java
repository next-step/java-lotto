package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import stringformula.Number;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoNumberTest {

    @Test
    @DisplayName("로또 번호를 생성한다")
    void 테스트_로또_번호_생성() {
        // given
        int number = 1;

        // when
        LottoNumber lottoNumber = new LottoNumber(number);

        // then
        assertThat(lottoNumber).isEqualTo(new LottoNumber(number));

    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    @DisplayName("로또 번호를 생성하는데 1 미만, 45 초과하는 값은 예외가 발생한다")
    void 테스트_로또_번호_생성_예외(int value) {
        // given
        // when
        // then
        assertThrows(IllegalArgumentException.class, () -> new LottoNumber(value));
    }
}