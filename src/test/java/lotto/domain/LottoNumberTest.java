package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {

    @DisplayName("로또번호의 정상적인 생성확인")
    @ParameterizedTest
    @ValueSource(ints = {1, 10, 45})
    public void createLottoNumber(int number) {
        LottoNumber lottoNumber = LottoNumber.create(number);

        assertThat(lottoNumber).isEqualTo(LottoNumber.create(number));
        assertThat(lottoNumber.value()).isEqualTo(number);
    }

    @DisplayName("로또번호의 비정상적인 범위에서의 예외확인")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    public void createInvalidLottoNumber(int number) {
        assertThatThrownBy(() -> LottoNumber.create(number))
                .isInstanceOf(IllegalArgumentException.class);

    }

}
