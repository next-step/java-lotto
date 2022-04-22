package me.devyonghee.lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.*;

@DisplayName("로또 번호들")
class LottoNumbersTest {

    @Test
    @DisplayName("객체화")
    void instance() {
        assertThatNoException().isThrownBy(() -> LottoNumbers.from(Arrays.asList(LottoNumber.from(1), LottoNumber.from(2), LottoNumber.from(3))));
    }

    @Test
    @DisplayName("로또 번호들은 필수")
    void instance_null_thrownNullPointerException() {
        assertThatNullPointerException().isThrownBy(() -> LottoNumbers.from(null));
    }

    @Test
    @DisplayName("로또 번호들은 1개 이상")
    void instance_empty_thrownIllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> LottoNumbers.from(Collections.emptyList()));
    }
}
