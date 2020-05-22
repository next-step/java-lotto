package lotto.domain.lotto;

import lotto.domain.lotto.exceptions.OutOfBoundOfLottoNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTests {
    @DisplayName("숫자를 입력받아서 로또 번호 객체를 생성할 수 있음")
    @Test
    void createLottoNumber() {
        LottoNumber lottoNumber = LottoNumber.create(1);
        assertThat(lottoNumber).isNotNull();
    }

    @DisplayName("1 ~ 45 범위의 값을 지난 객체만 생성할 수 있음")
    @ParameterizedTest
    @ValueSource(ints = { -100, 0, 46, 100 })
    void validationCheck(int invalidValue) {
        assertThatThrownBy(() -> LottoNumber.create(invalidValue))
                .isInstanceOf(OutOfBoundOfLottoNumberException.class);
    }

    @DisplayName("동등성 비교")
    @Test
    void equalTest() {
        assertThat(LottoNumber.create(1)).isEqualTo(LottoNumber.create(1));
    }
}
