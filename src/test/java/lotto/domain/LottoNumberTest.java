package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {

    @DisplayName("로또 숫자는 1부터 45까지 가능하다")
    @ParameterizedTest
    @ValueSource(ints = {0, -1, 46, 100})
    void 숫자_범위를_벗어난_경우(int number) {
        assertThatThrownBy(() -> LottoNumber.from(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자가 같으면 같은 LottoNumber로 취급한다")
    @Test
    void 동일_숫자_동일_객체() {
        LottoNumber test1 = LottoNumber.from(7);
        LottoNumber test2 = LottoNumber.from(7);
        assertThat(test1).isEqualTo(test2);
    }
}
