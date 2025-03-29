package lotto.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {

    @Test
    @DisplayName("유효한 범위의 숫자로 LottoNumber 객체를 생성할 수 있다")
    void createLottoNumberWithValidNumber() {
        LottoNumber lottoNumber = new LottoNumber(1);

        assertThat(lottoNumber).isNotNull();
    }

    @ParameterizedTest
    @DisplayName("유효하지 않은 숫자로 LottoNumber를 생성하면 예외가 발생한다")
    @ValueSource(ints = {0, -1, 46})
    void createLottoNumberWithNumberLessThanMinimum(int invalidNumber) {
        assertThatThrownBy(() -> new LottoNumber(invalidNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호는 1부터 45 사이의 숫자여야 합니다");
    }
}
