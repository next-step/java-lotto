package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LottoNumberTest {

    @ParameterizedTest
    @DisplayName("1~45 범위가 벗어나면 예외가 발생한다")
    @ValueSource(ints = {-1, 0, 46, 47})
    void wrongLottoNumberException(int lottoNumber) {
        assertThatIllegalArgumentException().isThrownBy(() -> LottoNumber.valueOf(lottoNumber))
                .withMessage("1 ~ 45 범위가 벗어난 값이 존재합니다.");
    }

    @Test
    @DisplayName("캐싱된 1~45 로또 번호를 가져온다")
    void valueOf() {
        for (int i = 1; i <= 45; i++) {
            assertThat(LottoNumber.valueOf(i).getLottoNumber()).isEqualTo(i);
        }
    }
}
