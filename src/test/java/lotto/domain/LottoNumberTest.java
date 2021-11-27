package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoNumberTest {

    @DisplayName("로또 번호 생성 확인")
    @Test
    void createLottoNumber() {
        int actual = 2;
        LottoNumber number = new LottoNumber(actual);

        assertThat(number).isNotNull();
        assertThat(number.getNumber()).isEqualTo(actual);
    }

    @DisplayName("로또 번호는 0에서 45사이의 값만 가능하다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46, 100})
    void createLottoNumberRange(Integer actual) {
        assertThatThrownBy(() -> new LottoNumber(actual))
                .isInstanceOf(RuntimeException.class);
    }
}
